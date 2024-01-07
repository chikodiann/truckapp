package com.ann.truckApp.services.impl;

import com.ann.truckApp.domain.enums.Type;
import com.ann.truckApp.domain.model.Users;
import com.ann.truckApp.domain.repository.UserRepository;
import com.ann.truckApp.dto.request.HandleLoginDTO;
import com.ann.truckApp.dto.request.HandleRegisterDTO;
import com.ann.truckApp.dto.response.BaseResponse;
import com.ann.truckApp.dto.response.LoginResponse;
import com.ann.truckApp.dto.response.RegisterResponse;
import com.ann.truckApp.exceptions.CustomerNotFoundException;
import com.ann.truckApp.security.JwtService;
import com.ann.truckApp.services.OTPService;
import com.ann.truckApp.services.UserService;
import com.ann.truckApp.utils.OtpUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ApplicationEventPublisher publisher;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private OTPService otpService;
    @Override
    public BaseResponse<?> handleRegister(HandleRegisterDTO handleRegisterDTO) {
        if(String.valueOf(handleRegisterDTO.getEmail()).isEmpty()){
            throw new CustomerNotFoundException("CUSTOMER_ERROR");
        }
        if(userRepository.existsByEmail(handleRegisterDTO.getEmail())){
            throw new CustomerNotFoundException("CUSTOMER_ALREADY_EXIST");
        }
        Users saveCustomer = saveUser(handleRegisterDTO);
        String otp = OtpUtils.generateOtp();
        otpService.sendotp_message(saveCustomer,otp);
        RegisterResponse save = modelMapper.map(saveCustomer, RegisterResponse.class);
        return new BaseResponse<>(save);

    }

    @Override
    public BaseResponse<?> handleLogin(HandleLoginDTO handleLoginDTO) {
        Users users = userRepository.findByEmail(handleLoginDTO.getEmail())
                .orElseThrow(()->new CustomerNotFoundException("USER_NOT_FOUND"));
        if(users.isStatus() && passwordEncoder.matches(handleLoginDTO.getPassword(),users.getPassword())){
            Authentication authentication = new UsernamePasswordAuthenticationToken(users.getEmail(),users.getPassword());
            String jwtToken = jwtService.generateToken(authentication);
            String refreshtoken = jwtService.generateRefreshToken(authentication);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return new BaseResponse<>(logginResponse(jwtToken,refreshtoken,users));
        }
        throw  new RuntimeException("INVALID_CREDENTIALS");
    }
    private LoginResponse logginResponse(String jwt, String refreshToken, Users customer){
        return LoginResponse.builder()
                .type(customer.getType())
                .accessToken(jwt)
                .refreshAccesstoken(refreshToken)
                .email(customer.getEmail())
                .build();
    }
    private Users saveUser(HandleRegisterDTO customer){
        return userRepository.save(Users.builder()
                .email(customer.getEmail())
                .type(Type.DRIVER)
                .password(passwordEncoder.encode(customer.getPassword()))

                .username(customer.getUsername())
                .status(false)
                .build());
    }
}

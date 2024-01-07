package com.ann.truckApp.web;

import com.ann.truckApp.dto.request.HandleLoginDTO;
import com.ann.truckApp.dto.request.HandleRegisterDTO;
import com.ann.truckApp.dto.response.BaseResponse;
import com.ann.truckApp.services.OTPService;
import com.ann.truckApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1")
@RestController
public class OTPController {
    @Autowired
    private OTPService otpService;

    @GetMapping("/verify-otp")
    public ResponseEntity<BaseResponse<?>> verify_otp(@RequestParam("email") String email, @RequestParam("otp") String otp ){
        return new ResponseEntity<>(otpService.verify_otp(email,otp), HttpStatus.OK);
    }

    @GetMapping("/resend-otp")
    public ResponseEntity<BaseResponse<?>> resend_otp(@RequestParam("email") String email ){
        return new ResponseEntity<>(otpService.resendOTP(email), HttpStatus.OK);
    }
}

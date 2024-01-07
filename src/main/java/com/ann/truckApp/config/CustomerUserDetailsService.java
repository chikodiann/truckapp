package com.ann.truckApp.config;


import com.ann.truckApp.domain.enums.Type;
import com.ann.truckApp.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.springframework.security.core.GrantedAuthority;
import java.util.Collection;
import java.util.Collections;
import org.springframework.security.core.userdetails.User;
import com.ann.truckApp.domain.model.Users;
@Service
@RequiredArgsConstructor
public class CustomerUserDetailsService implements UserDetailsService {

    private final UserRepository customerRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = customerRepository.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("USER NOT FOUND"));
        return new User(user.getUsername(),user.getPassword(),getAuthorities(user));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Users user){
        return Collections.singletonList(new SimpleGrantedAuthority(Type.DRIVER.name()));
    }
}
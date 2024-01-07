package com.ann.truckApp.web;

import com.ann.truckApp.dto.request.HandleLoginDTO;
import com.ann.truckApp.dto.request.HandleRegisterDTO;
import com.ann.truckApp.dto.response.BaseResponse;
import com.ann.truckApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<BaseResponse<?>> create(@RequestBody HandleRegisterDTO handleRegisterDTO){
        return new ResponseEntity<>(userService.handleRegister(handleRegisterDTO), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<BaseResponse<?>> login(@RequestBody HandleLoginDTO handleLoginDTO){
        return new ResponseEntity<>(userService.handleLogin(handleLoginDTO), HttpStatus.OK);
    }
}

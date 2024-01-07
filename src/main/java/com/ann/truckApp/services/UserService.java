package com.ann.truckApp.services;

import com.ann.truckApp.dto.request.HandleLoginDTO;
import com.ann.truckApp.dto.request.HandleRegisterDTO;
import com.ann.truckApp.dto.response.BaseResponse;

public interface UserService {
    public BaseResponse<?> handleRegister(HandleRegisterDTO handleRegisterDTO);
    public  BaseResponse<?> handleLogin(HandleLoginDTO handleLoginDTO);
}

package com.ann.truckApp.services;

import com.ann.truckApp.domain.model.Users;
import com.ann.truckApp.dto.response.BaseResponse;

public interface OTPService {
    public void sendotp_message(Users users, String otp);
    public BaseResponse<String> verify_otp(String email,String otp);
    public BaseResponse<String> resendOTP(String email);
}

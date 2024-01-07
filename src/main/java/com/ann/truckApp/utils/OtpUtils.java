package com.ann.truckApp.utils;
import java.util.UUID;
public class OtpUtils {
    public static String generateOtp(){
        return  UUID.randomUUID().toString().substring(0,4);
    }
}

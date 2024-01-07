package com.ann.truckApp.exceptions.handler;

import com.ann.truckApp.dto.response.BaseResponse;
import com.ann.truckApp.exceptions.CustomExceptionResponse;
import com.ann.truckApp.exceptions.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerExceptions {
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<BaseResponse<CustomExceptionResponse>> customerException(CustomerNotFoundException e){
        CustomExceptionResponse customExceptionResponse = CustomExceptionResponse.builder()
                .message(e.getMessage())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .dates("")
                .build();
        BaseResponse<CustomExceptionResponse> apiResponse = new BaseResponse<>(customExceptionResponse);
        return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);
    }
}
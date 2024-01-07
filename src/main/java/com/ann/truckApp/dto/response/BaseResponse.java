package com.ann.truckApp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BaseResponse<T> {
    private String message;
    private Integer statusCode;
    private T data;
    public BaseResponse(T data,String message,Integer status){
        this.data=data;
        this.message=message;
        this.statusCode=status;
    }
    public BaseResponse(T data){
        this.data=data;
        this.message="Api received";
        this.statusCode=201;
    }

}

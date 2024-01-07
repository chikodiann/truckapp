package com.ann.truckApp.exceptions;

public class CustomerNotFoundException  extends RuntimeException{
   public CustomerNotFoundException(String message){
        super(message);
    }
}
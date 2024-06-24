package com.example.furniture.core.exception;

public class UserAccountNotFoundException extends RuntimeException{
    public UserAccountNotFoundException (String message){
        super(message);
    }
}

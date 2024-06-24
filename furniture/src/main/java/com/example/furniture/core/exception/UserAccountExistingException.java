package com.example.furniture.core.exception;

public class UserAccountExistingException extends RuntimeException{
    public UserAccountExistingException(String message){
        super(message);
    }
}

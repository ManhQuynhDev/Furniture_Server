package com.example.furniture.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.furniture.core.validation.ResponseObject;

import jakarta.servlet.http.HttpServletRequest;

@SuppressWarnings({ "rawtypes", "unchecked" })
@ControllerAdvice
public class FurnitureExceptionHandler {
    @ExceptionHandler(value = { UserAccountExistingException.class, UserAccountNotFoundException.class , ShipmentNotFoundException.class , ProductNotFoundException.class})
    public ResponseEntity<?> isExist(Exception ex , HttpServletRequest request) {
        ResponseObject response = new ResponseObject();
        response.setStatus("failed");
        response.setMessage("Data is invalid.");
        return new ResponseEntity<ResponseObject>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<?> handleValingValidation (MethodArgumentNotValidException ex) {
        ResponseObject response = new ResponseObject();
        response.setStatus("failed");
        response.setMessage("Data is invalid.");
        return new ResponseEntity<ResponseObject>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {UnknowException.class})
    public ResponseEntity<?> unknow (Exception ex, HttpServletRequest request){
        ResponseObject response = new ResponseObject();
        response.setStatus("failed");
        response.setMessage("Something went wrong!.");
        return new ResponseEntity<ResponseObject>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
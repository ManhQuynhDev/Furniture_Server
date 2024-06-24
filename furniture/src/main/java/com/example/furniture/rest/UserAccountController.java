package com.example.furniture.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.furniture.core.exception.UserAccountNotFoundException;
import com.example.furniture.core.validation.ResponseObject;
import com.example.furniture.dto.User;
import com.example.furniture.services.OnboardingService;

import jakarta.validation.Valid;

/**
 * UserAccountController
 */

@RestController
@RequestMapping("/users")
public class UserAccountController {
    @Autowired
    private OnboardingService onboardingService;

    @PostMapping("")
    public ResponseEntity<ResponseObject> register(@RequestBody @Valid User user) {
        onboardingService.register(user);
        ResponseObject result = new ResponseObject();
        result.setStatus("ok");
        result.setMessage("Create a new account successfully");
        return new ResponseEntity<ResponseObject>(result, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseObject> login(@RequestBody @Valid User user) {
        ResponseObject result = new ResponseObject();
        try {
            boolean isCheck = onboardingService.login(user);
            System.out.println(isCheck);
            result.setStatus("ok");
            result.setMessage("Login successfully");
            result.setData(isCheck);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (UserAccountNotFoundException e) {
            result.setStatus("error");
            result.setMessage(e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            result.setStatus("error");
            result.setMessage("An unknown error occurred" + e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
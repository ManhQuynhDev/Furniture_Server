package com.example.furniture.services;

import com.example.furniture.core.exception.UnknowException;
import com.example.furniture.core.exception.UserAccountExistingException;
import com.example.furniture.core.exception.UserAccountNotFoundException;
import com.example.furniture.dto.User;
import com.example.furniture.repositories.AccountRepository;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OnboardingService {

    @Autowired
    private AccountRepository repository;

    public void register(User newUser) throws UserAccountExistingException, UnknowException {
        User foundUser = repository.findByUsername(newUser.getUsername().trim());
        if (foundUser != null) {
            throw new UserAccountExistingException(
                    "Username " + newUser.getUsername() + " already exist. Please try an other!");
        }
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String hashPassword = passwordEncoder.encode(newUser.getPassword());
        User saveUser = User.builder()
                .username(newUser.getUsername()).password(hashPassword)
                .build();
        User user = repository.save(saveUser);
        if (user.getUser_id() == null) {
            throw new UnknowException("Transaction cannot complete!");
        }
    }
    public boolean login(User newUser) throws UserAccountNotFoundException , UnknowException {
        User foundUser = repository.findByUsername(newUser.getUsername().trim());
        if (foundUser == null) {
            throw new UserAccountNotFoundException(
                    "Username " + newUser.getUsername() + " not found. Please try an other!");
        }
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return passwordEncoder.matches(newUser.getPassword(),foundUser.getPassword());
    }
}

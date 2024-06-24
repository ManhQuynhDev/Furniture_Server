package com.example.furniture.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.furniture.dto.User;



public interface AccountRepository extends JpaRepository<User , Integer>{
    User findByUsername(String username);
}

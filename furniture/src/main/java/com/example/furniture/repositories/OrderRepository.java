package com.example.furniture.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.furniture.dto.Order;

public interface OrderRepository extends JpaRepository<Order , Integer>{
    
}

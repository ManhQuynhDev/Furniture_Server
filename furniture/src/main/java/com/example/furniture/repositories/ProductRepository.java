package com.example.furniture.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.furniture.dto.Product;

public interface ProductRepository extends JpaRepository<Product , Integer>{
    
}

package com.example.furniture.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.furniture.dto.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
    
}

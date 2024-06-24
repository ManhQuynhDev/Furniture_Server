package com.example.furniture.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.furniture.dto.Category;
import com.example.furniture.repositories.CategoryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    public List<Category> getAllListData (){
        return repository.findAll();
    }
}

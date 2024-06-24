package com.example.furniture.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.furniture.core.exception.ProductNotFoundException;
import com.example.furniture.dto.Product;
import com.example.furniture.repositories.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> getAllListData() {
        return repository.findAll();
    }

    public Product getAnProductById(int product_id) throws ProductNotFoundException {
        Product product = repository.findById(product_id)
                .orElseThrow(() -> new ProductNotFoundException("Product id is null please try again"));
        return product;
    }
}

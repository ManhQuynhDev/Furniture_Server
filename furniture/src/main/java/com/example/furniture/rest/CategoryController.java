package com.example.furniture.rest;

import org.springframework.web.bind.annotation.RestController;

import com.example.furniture.core.validation.ResponseObject;
import com.example.furniture.dto.Category;
import com.example.furniture.services.CategoryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/category")

public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<ResponseObject> getAllListData() {
        List<Category> list = categoryService.getAllListData();
        ResponseObject result = new ResponseObject();
        result.setStatus("ok");
        result.setMessage("call list data successfully");
        result.setData(list);
        return new ResponseEntity<ResponseObject>(result, HttpStatus.OK);
    }
}

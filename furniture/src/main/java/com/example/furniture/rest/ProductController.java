package com.example.furniture.rest;

import org.springframework.web.bind.annotation.RestController;

import com.example.furniture.core.validation.ResponseObject;
import com.example.furniture.dto.Category;
import com.example.furniture.dto.Product;
import com.example.furniture.services.ProductService;

import java.util.List;

import org.apache.tomcat.util.openssl.pem_password_cb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/product")
public class ProductController {
    
    @Autowired
    private ProductService service;

    @GetMapping("")
    public ResponseEntity<ResponseObject> getAllListData() {
        List<Product> list = service.getAllListData();
        ResponseObject result = new ResponseObject();
        result.setStatus("ok");
        result.setMessage("call list data successfully");
        result.setData(list);
        return new ResponseEntity<ResponseObject>(result, HttpStatus.OK);
    }

    @GetMapping("/{product_id}")
    public ResponseEntity<ResponseObject> getProductById(@PathVariable("product_id") int product_id) {
        Product product = service.getAnProductById(product_id);
        ResponseObject result = new ResponseObject();
        result.setStatus("ok");
        result.setMessage("call product data successfully");
        result.setData(product);
        return new ResponseEntity<ResponseObject>(result, HttpStatus.OK);
    }
}

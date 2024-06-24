package com.example.furniture.rest;

import org.springframework.web.bind.annotation.RestController;

import com.example.furniture.core.validation.ResponseObject;
import com.example.furniture.dto.Comment;
import com.example.furniture.dto.Order;
import com.example.furniture.dto.Product;
import com.example.furniture.services.CommentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService service;

     @GetMapping("")
    public ResponseEntity<ResponseObject> getAllListData() {
        List<Comment> list = service.getAllListData();
        ResponseObject result = new ResponseObject();
        result.setStatus("ok");
        result.setMessage("get all list data successfully");
        result.setData(list);
        return new ResponseEntity<ResponseObject>(result, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<ResponseObject> insertShipment(@RequestBody Comment comment) {
        service.insertComment(comment);
        ResponseObject result = new ResponseObject();
        result.setStatus("ok");
        result.setMessage("Create a new comment successfully");
        return new ResponseEntity<ResponseObject>(result, HttpStatus.OK);
    }
}

package com.example.furniture.rest;

import org.springframework.web.bind.annotation.RestController;

import com.example.furniture.core.validation.ResponseObject;
import com.example.furniture.dto.Order;
import com.example.furniture.dto.Shipment;
import com.example.furniture.services.OrderService;

import jakarta.validation.Valid;

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
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService service;
    
     @GetMapping("")
    public ResponseEntity<ResponseObject> getAllListData() {
        List<Order> list = service.getAllListData();
        ResponseObject result = new ResponseObject();
        result.setStatus("ok");
        result.setMessage("get all list data successfully");
        result.setData(list);
        return new ResponseEntity<ResponseObject>(result, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<ResponseObject> insertShipment(@RequestBody Order order) {
        service.insertOrder(order);
        ResponseObject result = new ResponseObject();
        result.setStatus("ok");
        result.setMessage("Create a new order successfully");
        return new ResponseEntity<ResponseObject>(result, HttpStatus.OK);
    }
    @PutMapping("/{order_id}")
    public ResponseEntity<ResponseObject> updateOrder(@PathVariable("order_id") int order_id, @RequestBody Order order) {
        service.updateOrder(order_id,order);
        ResponseObject result = new ResponseObject();
        result.setStatus("ok");
        result.setMessage("update order successfully");
        return new ResponseEntity<ResponseObject>(result, HttpStatus.OK);
    }
}

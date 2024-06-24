package com.example.furniture.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.furniture.core.exception.ProductNotFoundException;
import com.example.furniture.core.exception.UnknowException;
import com.example.furniture.core.exception.UserAccountNotFoundException;
import com.example.furniture.dto.Order;
import com.example.furniture.dto.Product;
import com.example.furniture.dto.User;
import com.example.furniture.repositories.AccountRepository;
import com.example.furniture.repositories.OrderRepository;
import com.example.furniture.repositories.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllListData() {
        return orderRepository.findAll();
    }

    //Insert
    public void insertOrder(Order order) throws UserAccountNotFoundException, ProductNotFoundException, UnknownError {
        Order orderSave = orderRepository.save(order);
        //Check success
        if (orderSave.getOrder_id() == null) {
            throw new UnknowException("Transaction cannot complete!");
        }
    }
    public void updateOrder (int order_id , Order order) throws ProductNotFoundException, UnknownError{
        Order orderUpdate = orderRepository.findById(order_id).orElseThrow(() ->  new ProductNotFoundException("Order not found"));

        orderUpdate.setState(order.getState());

        orderRepository.save(orderUpdate);
    }
}

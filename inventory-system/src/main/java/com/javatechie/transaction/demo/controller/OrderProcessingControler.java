package com.javatechie.transaction.demo.controller;

import com.javatechie.transaction.demo.entity.Order;
import com.javatechie.transaction.demo.service.OrderProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderProcessingControler{

    private OrderProcessingService orderProcessingService;
    @Autowired
    public void setOrderProcessingService(OrderProcessingService orderProcessingService){
        this.orderProcessingService = orderProcessingService;
    }

    @PostMapping("/")
    public ResponseEntity<?> placeOrder(@RequestBody  Order order){
        return ResponseEntity.ok(orderProcessingService.placeAnOrder(order));
    }
}

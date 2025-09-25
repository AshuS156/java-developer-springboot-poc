package com.example.spring.constructor.injection.service;

import org.springframework.stereotype.Component;

@Component
public class Order{

    Order() {
        System.out.println("Order bean creation!!!");
    }

    public void processOrder() {
        System.out.println("start processing your order....");
    }
}

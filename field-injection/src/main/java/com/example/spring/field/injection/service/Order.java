package com.example.spring.field.injection.service;

import org.springframework.stereotype.Component;

@Component
public class Order{

    public void processOrder() {
        System.out.println("start processing your order....");
    }
}

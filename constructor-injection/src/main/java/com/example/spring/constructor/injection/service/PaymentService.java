package com.example.spring.constructor.injection.service;


import org.springframework.stereotype.Component;

@Component
public class PaymentService{

    PaymentService() {
        System.out.println("PaymentService bean creation");
    }

}

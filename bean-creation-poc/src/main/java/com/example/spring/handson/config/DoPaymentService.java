package com.example.spring.handson.config;

import com.example.spring.handson.service.GooglePay;
import com.example.spring.handson.service.PaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DoPaymentService{

    @Bean
    public PaymentService googlePayService() {
        System.out.println("do payment by googlePayService");
        return new GooglePay();
    }
}

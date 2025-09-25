package com.example.spring.handson.service;

public class GooglePay implements PaymentService{
    @Override
    public void doPayment(){
        System.out.println("doPayment using google pay...");
    }
}

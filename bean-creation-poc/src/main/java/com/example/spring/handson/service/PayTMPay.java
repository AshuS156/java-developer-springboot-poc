package com.example.spring.handson.service;

public class PayTMPay implements PaymentService{
    @Override
    public void doPayment(){
        System.out.println("doPayment by paytm....");
    }
}

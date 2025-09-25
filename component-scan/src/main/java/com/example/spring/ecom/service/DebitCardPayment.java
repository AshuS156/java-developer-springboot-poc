package com.example.spring.ecom.service;

public class DebitCardPayment implements PaymentService{

    public DebitCardPayment() {
        System.out.println("DebitCardPayment");
    }
    @Override
    public void doPayment(){
        System.out.println("payment done by Debit card !!!!!");
    }
}

package com.example.spring.ecom.service;

public class CreditCardPayment implements PaymentService{

   public CreditCardPayment() {
        System.out.println("CreditCardPayment");
    }
    @Override
    public void doPayment(){
        System.out.println("payment done by credit card ... ");
    }
}

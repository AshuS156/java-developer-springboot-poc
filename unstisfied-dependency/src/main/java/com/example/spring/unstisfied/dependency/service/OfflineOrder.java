package com.example.spring.unstisfied.dependency.service;

import org.springframework.stereotype.Component;

@Component
public class OfflineOrder implements Order{

    OfflineOrder() {
        System.out.println("OfflineOrder getting initilazed");
    }
    @Override
    public void placeOrder(){

        System.out.println("place offline order....");

    }
}

package com.example.spring.unstisfied.dependency.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
// use @Autowired & @primary at field injection level
@Primary
public class OnlineOrder implements Order{

    OnlineOrder() {
        System.out.println("OnlineOrder getting initilazed");
    }
    @Override
    public void placeOrder(){

        System.out.println("place online order....");

    }
}

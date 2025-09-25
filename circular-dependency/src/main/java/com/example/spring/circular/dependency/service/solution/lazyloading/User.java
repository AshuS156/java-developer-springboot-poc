package com.example.spring.circular.dependency.service.solution.lazyloading;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class User{

    @Autowired
   // @Lazy : approach using lazt initialization
    private Order order;

    // added as part of second approch
    @PostConstruct
    public void init() {
        order.setOrder(this);
    }

    User(){
        System.out.println("User bean creation !!!!!" + User.class.getPackageName());
    }

}

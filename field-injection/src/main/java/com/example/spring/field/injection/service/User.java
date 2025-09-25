package com.example.spring.field.injection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User{


    /*  field injection disadvantage
  1. Cannot use with Immutable object/ final refrence. Below code will give compilation error
     @Autowired
      public final  Order order;

  2. There is a chance of NPE - execute the main method directly from this class
    becuase in main method we are trying to create User object manually and which is not created by Spring container
    so Order object will not be initialze and failed with NPE
     */

    @Autowired
    private Order order;

    public static void main(String[] args){
        User user = new User();
        user.process();
    }

    public void process(){
        order.processOrder();
    }

}

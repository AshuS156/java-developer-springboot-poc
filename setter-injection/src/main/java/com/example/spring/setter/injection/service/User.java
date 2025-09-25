package com.example.spring.setter.injection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User{


    /*  setter injection disadvantage
  1. Cannot use with Immutable object/ final refrence

   public final Order order;

  2. There is a chance of NPE - execute the main method directly from this class
     */

    private Order order;

    public static void main(String[] args){
        User user = new User();
        user.process();
    }

    @Autowired
    public void setOrder(Order order){
        this.order = order;
    }

    public void process(){
        order.processOrder();
    }

}

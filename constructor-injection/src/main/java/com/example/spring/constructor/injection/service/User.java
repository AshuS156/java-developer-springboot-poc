package com.example.spring.constructor.injection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class User{

    /*
      it is best practise to use constructor injection .
      its will not throw NPE
      it will work with Immuable /final object as well
      its fail safe - means if all dependent beans got initialize then only main bean will be initilaze other wise
      if you are having only 1 constructor in your class then using - @Autowired annotation is optional
      But if you are having more than 1 - constructor in your class then  @Autowired annotation is mandatory
      You can not mark two constructor with @Autowired at a time- you will get BeanCreationexp.

     */

    Order order;

    PaymentService paymentService;

    public User(PaymentService paymentService){
        this.paymentService = paymentService;
    }

   /* @Autowired
    public User(Order order){
        this.order = order;
    }*/

  /*  public User(){
        System.out.println("user bean defalt cons calling...");
    }*/

    @Autowired
    User(Order order,PaymentService paymentService) {
        this.order = order;
        this.paymentService  = paymentService;
    }

    public void process() {
        order.processOrder();
    }
/*
    public static void main(String[] args){
        User user = new User(new Order());
        user.process();
    }*/

}

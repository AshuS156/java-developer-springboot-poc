package com.example.spring.unstisfied.dependency.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class User{


    // use @Autowired & @primary at field injection level

    @Autowired
    Order order;



    // use @Autowired & @Qualifier at setter injection level
  /*  @Autowired
    public void setOrder(@Qualifier("offlineOrder") Order order){
        this.order = order;
    }*/


    // use @Autowired & @Qualifier at constructor injection level
    /* @Autowired
    User(@Qualifier("onlineOrder") Order order) {
        this.order = order;
        System.out.println("User class cons calling!!!! and initializing user bean....");
    }*/
}

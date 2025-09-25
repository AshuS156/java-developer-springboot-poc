package com.example.spring.beanscope.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class UserService{

    UserService() {
        System.out.println("User service bean creation");
    }
}

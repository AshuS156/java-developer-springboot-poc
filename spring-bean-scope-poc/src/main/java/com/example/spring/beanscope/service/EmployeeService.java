package com.example.spring.beanscope.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class EmployeeService{
    @Autowired
    UserService userService;

    EmployeeService() {
        System.out.println("Employee servcie bean creation");
    }

    @PostConstruct
    public void init() {
        System.out.println("UserService hascode : "+userService.hashCode());
    }
}

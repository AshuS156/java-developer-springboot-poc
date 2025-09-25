package com.example.spring.beanscope.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "request")
public class DBConnection{

    @Autowired
    UserService userService;
    @Autowired
    NoSQLConnection noSQLConnection;


    DBConnection() {
        System.out.println("DBConnection bean creation !!!!" );
    }

    @PostConstruct
    public void init() {
        System.out.println("DB Connection init ");

        System.out.println("NoSQLConnection hashcode : "+ noSQLConnection.hashCode());
        System.out.println("UserService hashcode : "+ userService.hashCode());
    }
}

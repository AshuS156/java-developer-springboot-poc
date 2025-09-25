package com.example.spring.beanscope.service;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
//@Scope(value = "prototype")
public class NoSQLConnection{

    NoSQLConnection() {
        System.out.println("NoSQLConnection bean creation!!!!");
    }
}

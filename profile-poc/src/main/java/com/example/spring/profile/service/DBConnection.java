package com.example.spring.profile.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DBConnection{

    @Value("${uname}")

    private String username;
    @Value("${pwd}")
    private String passwrod;
    @Value("${racf}")
    private String racf;

/*
    @Autowired(required = false)
    NoSQLDbConnection noSQLDbConnection;
*/

   /* @Autowired(required = false)
    SQLDbConnection sqlDbConnection;*/
    DBConnection() {
        System.out.println("DBConnection initialized!!!!!");
    }

    @PostConstruct
    public void init() {

        System.out.println("username : "+ username);
        System.out.println("passwrod : "+ passwrod);
        System.out.println("racf : "+ racf);
    }


}

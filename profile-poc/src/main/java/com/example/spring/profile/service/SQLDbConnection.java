package com.example.spring.profile.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("qa")
public class SQLDbConnection{

    @Value("${uname}")

    private String username;
    @Value("${pwd}")
    private String passwrod;
    @Value("${racf}")
    private String racf;

    SQLDbConnection() {
        System.out.println("SQLDbConnection creaed as profile is qa !!!!" );

    }


}

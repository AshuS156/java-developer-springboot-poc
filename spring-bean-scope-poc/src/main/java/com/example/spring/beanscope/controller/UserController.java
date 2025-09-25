package com.example.spring.beanscope.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController{


    @GetMapping("/getuser")
    public ResponseEntity<?> getUser(){
        return ResponseEntity.status(HttpStatus.OK).body("Get User");
    }
}

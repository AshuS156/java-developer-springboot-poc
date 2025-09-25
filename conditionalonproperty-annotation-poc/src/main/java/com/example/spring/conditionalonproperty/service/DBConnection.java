package com.example.spring.conditionalonproperty.service;


import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBConnection{

    private static final Logger logger = LoggerFactory.getLogger(DBConnection.class);
    @Autowired(required = false)
    NoSQLConnection noSQLConnection;

    @Autowired
    SQLConnection sqlConnection;


    @PostConstruct
    public void init() {
        logger.info("post construct calling !!!!!");
       logger.info("noSQLConnection hashCode: {}", noSQLConnection.hashCode());
        logger.info("sqlConnection hashCode : {}", sqlConnection.hashCode());

    }
}

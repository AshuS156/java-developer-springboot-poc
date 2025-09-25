package com.example.spring.conditionalonproperty.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBooleanProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnBooleanProperty(prefix ="NoSQLConnection",
value ="enabled",
havingValue = true,
matchIfMissing = true)
public class NoSQLConnection{

    private static final Logger logger = LoggerFactory.getLogger(NoSQLConnection.class);

    NoSQLConnection() {
        logger.info("NoSQLConnection bean has been created and initializes!!!!");
    }
}

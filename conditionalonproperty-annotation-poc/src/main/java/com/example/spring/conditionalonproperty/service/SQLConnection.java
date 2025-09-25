package com.example.spring.conditionalonproperty.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBooleanProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnBooleanProperty(prefix ="SQLConnection",
        value ="enabled",
        havingValue = true,
        matchIfMissing = false)
public class SQLConnection{

    private static final Logger logger = LoggerFactory.getLogger(SQLConnection.class);
    SQLConnection() {
        logger.info("SQLConnection bean created and initialzed !!!");

    }
}

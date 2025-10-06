package com.pathfinder.aop.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pathfinder.aop.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserUtility{

    private static Logger logger = LoggerFactory.getLogger(UserUtility.class);

    public static User fetchAllUser(){
        User user = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File("src/main/resources/user.json");
            user = objectMapper.readValue(file,User.class);
        } catch (IOException e) {
            logger.error("Error reading user data from JSON file",e);
        }
        logger.info("User data loaded from JSON: {}",user);
        return user;
    }

    public static List<User> loadJsonData(){
        List<User> users = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File("src/main/resources/userMockData.json");
            users = objectMapper.readValue(file , new TypeReference<List<User>>(){});
        } catch (IOException e) {
            logger.error("Error reading user data from JSON file",e);
        }
        logger.info("User data loaded from JSON: {}",users);
        return users;
    }

    public static User getUserById(Long id){
        final User user1 = loadJsonData().stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
        logger.info("User found with ID {}: {}", id, user1);
        return user1;
    }

    public static List<User> getUserByStatus(String status){
        final List<User> list = loadJsonData().stream().filter(user -> user.getStatus().equalsIgnoreCase(status)).toList();
        logger.info("Users found with status {}: {}", status, list);
        return list;

    }

    public static List<User> getUserByNameAndStatus(String name, String status){
        final List<User> list = loadJsonData().stream().filter(user -> user.getName().equalsIgnoreCase(name) && user.getStatus().equalsIgnoreCase(status)).toList();
        logger.info("Users found with name {} and status {}: {}", name, status, list);
        return list;
    }


}

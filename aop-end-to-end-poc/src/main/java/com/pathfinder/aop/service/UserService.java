package com.pathfinder.aop.service;

import com.pathfinder.aop.bean.User;
import com.pathfinder.aop.repository.UserUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService{

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public User getUserById(Long userId){
        final User userById = UserUtility.getUserById(userId);
        logger.info("User with ID {}: {}",userId,userById);
        return userById;
    }

    public List<User> getUserByStatus(String status){
        final List<User> userByStatus = UserUtility.getUserByStatus(status);
        logger.info("Users with status {}: {}",status,userByStatus);
        return userByStatus;
    }

    public List<User> getUserByNameAndStatus(String name,String status){
        final List<User> userByNameAndStatus = UserUtility.getUserByNameAndStatus(name,status);
        logger.info("Users with name {} and status {}: {}",name,status,userByNameAndStatus);
        return userByNameAndStatus;
    }

    public User saveUser(User user){
        if(user.getName() == null || user.getName().isEmpty()){
            throw new IllegalArgumentException("User name cannot be null or empty");
        }
        logger.info("Saving user: {}",user);
        return user;
    }

}

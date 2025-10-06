package com.pathfinder.aop.controller;

import com.pathfinder.aop.bean.User;
import com.pathfinder.aop.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController{

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping(path = "/saveUser",consumes = "application/json",produces = "application/json")
    public ResponseEntity<User> saveUser(@RequestBody  User user){
        final User user1 = userService.saveUser(user);
        return ResponseEntity.ok(user1);
    }

    @GetMapping(path = "/getUserByStatus",produces = "application/json")
    public  ResponseEntity<List<User>> getUserByStatus(@RequestParam(name="userStatus") String status){
        final List<User> userByStatus = userService.getUserByStatus(status);
        return ResponseEntity.ok(userByStatus);
    }


    @GetMapping(path = "/getUserById/{userId}",produces = "application/json")
    public  ResponseEntity<User> getUserById(@PathVariable(name="userId") Long id){
        final User userById = userService.getUserById(id);
        return ResponseEntity.ok(userById);
    }

    @GetMapping(path = "/getUserByNameAndStatus",produces = "application/json")
    public  ResponseEntity<List<User>> getUserByNameAndStatus(@RequestParam(name="userName") String name,
                                                              @RequestParam(name="userStatus") String status){
        final List<User> userByNameAndStatus = userService.getUserByNameAndStatus(name,status);
        return ResponseEntity.ok(userByNameAndStatus);
    }
}

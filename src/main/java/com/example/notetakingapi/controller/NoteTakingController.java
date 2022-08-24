package com.example.notetakingapi.controller;

import com.example.notetakingapi.entity.User;
import com.example.notetakingapi.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteTakingController {

    @Autowired
    UserServiceInterface userServiceInterface;

    @PostMapping("/user")
    public User createUser(@RequestBody User user){



        return userServiceInterface.addUser(user);
    }
}

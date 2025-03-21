package com.example.BCrypt_5.controller;

import com.example.BCrypt_5.model.User;
import com.example.BCrypt_5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    // Registering a new user
    @PostMapping("/register")
    public User register(@RequestBody User user){
        return service.saveUser(user);
    }
}

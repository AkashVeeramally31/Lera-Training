package com.example.AdvancedErrorHandling.controller;

import com.example.AdvancedErrorHandling.model.User;
import com.example.AdvancedErrorHandling.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public List<User> getAllUsers(){
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id){
        return service.getUserById(id);
    }

    @PostMapping
    public String addUser(@RequestBody User user){
        return service.addUser(user);
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable int id,@RequestBody User user){
        return service.updateUser(id,user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id){
        return service.deleteUser(id);
    }
}

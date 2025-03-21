package com.example.SpringBootProfilesAndConfigurations.Controller;

import com.example.SpringBootProfilesAndConfigurations.Model.User;
import com.example.SpringBootProfilesAndConfigurations.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @Profile("dev")     // This is another way using @Profile annotation
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository repo;

    @GetMapping()
    public List<User> getAllUsers(){
       return repo.findAll();
    }

    @PostMapping()
    public String addUser(@RequestBody User user){
        repo.save(user);
        return "User added successfully";
    }
}

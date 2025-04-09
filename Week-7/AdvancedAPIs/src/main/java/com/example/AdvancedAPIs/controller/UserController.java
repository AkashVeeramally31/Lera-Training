package com.example.AdvancedAPIs.controller;

import com.example.AdvancedAPIs.model.User;
import com.example.AdvancedAPIs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService service;

    // Get all users.
    @GetMapping
    public Page<User> getUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String order){

        return service.getUsers(page, size, sortBy,order);
    }

    // Get Users filtered with Age.
    @GetMapping("/age")
    public Page<User> getUsersByAge(@RequestParam int age,
                                    @RequestParam(defaultValue = "0")int page,
                                    @RequestParam(defaultValue = "5")int size){
        return service.getUsersByAge(age,page,size);
    }
}

// GET /api/users
// Gives only five user details because size=5 i.e., 5 users per page. And in the next page
// i.e., in page-1 there will be remaining five records.

// GET /api/users?sortBy=name
// Sorts by name in ascending order.

// GET /api/users?sortBy=age&order=dsc
// Sorts by age in descending order.

// GET /api/users?page=1&size=5
// Get paginated users (page 2, 5 per page)

// GET /api/users/age?age=21
// Get users filtered by age=21.
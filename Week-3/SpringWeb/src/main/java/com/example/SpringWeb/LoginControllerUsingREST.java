package com.example.SpringWeb;

import org.springframework.web.bind.annotation.*;

@RestController
public class LoginControllerUsingREST {
    @GetMapping("/login")
    public String login() {
        return "Login Page..";
    }
    //To see the output of login() method use : http://localhost:8081/login
}

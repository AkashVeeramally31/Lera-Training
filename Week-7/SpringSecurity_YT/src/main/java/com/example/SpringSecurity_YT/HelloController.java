package com.example.SpringSecurity_YT;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String get(HttpServletRequest request) {
        return "Hello World! and Session id: " + request.getSession().getId();
    }
}

package com.example.Authentication.Securing.APIs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    // 1) Public Endpoint (No Authentication)
    @GetMapping("/api/public")
    public String publicEndPoint(){
        return "This is the public endpoint";
    }

    // 2) Protected User Endpoint
    @GetMapping("/api/user")
    public String userAndAdminEndPoint(){
        return "Hello User! You have user or admin role..";
    }

    // 3) Admin-Only Endpoint
    @GetMapping("/api/admin")
    public String adminEndPoint(){
        return "Hello Admin! You have admin role..";
    }
}

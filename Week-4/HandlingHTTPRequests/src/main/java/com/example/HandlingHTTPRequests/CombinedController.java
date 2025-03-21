package com.example.HandlingHTTPRequests;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CombinedController {

    @GetMapping("/user1/{id}")
    public String getUserBy(@PathVariable int id, @RequestParam String name){
        return "User with Id:"+id+" and Name:"+name;
    }

    //Making 'name' optional.
    @GetMapping("/user2/{id}")
    public String getUser(@PathVariable int id, @RequestParam(required = false) String name){
        return "User with Id:"+id+" and Name:"+((name!=null)?name:"Not Provided");
    }
}

// http://localhost:8080/api/user1/10?name=Akash
// http://localhost:8080/api/user2/10 -> for this, the output will be: User with Id:10 and Name:Not Provided

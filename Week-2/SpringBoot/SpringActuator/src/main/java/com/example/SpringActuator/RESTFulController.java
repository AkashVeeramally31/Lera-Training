package com.example.SpringActuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/get")
public class RESTFulController {
    @Autowired
    UserEntity entity;

    @GetMapping("/data")
    public UserEntity getEntity(){
        return entity;
    }
}

//Navigate to this url:- http://localhost:8081/get/data

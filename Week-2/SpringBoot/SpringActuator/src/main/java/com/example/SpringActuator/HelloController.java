package com.example.SpringActuator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, Actuator is Running!";
    }
}


//http:localhost:8081/(@RequestMapping)/(@GetMapping)  i.e..,
//Navigate to this URL:- http://localhost:8081/api/hello

package com.example.SpringWeb;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeControllerUsingREST {
    @RequestMapping("/")    // '/' is used to map to the server.
    public String greet(){
        return "Hello, Welcome to Spring Web";
    }
    //To see the output of greet() method use : http://localhost:8081/

    @RequestMapping("/about")
    public String about(){
        return "Hello, Welcome to About Page..";
    }
    //To see the output of about() method use : http://localhost:8081/about
}

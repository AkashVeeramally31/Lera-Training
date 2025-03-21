package com.example.HandlingHTTPRequests;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RequestParamController {

    // 1)
    @GetMapping("/users1")
    public String getUserByQueryParam(@RequestParam String name,@RequestParam(required = false,defaultValue = "0")
                                                                                        int age){
        return "User: "+name+" and Age: "+age;
    }

    // 2)
    //Multiple Query Parameters as a List
    @GetMapping("/users2")
    public String getUsersByQueryParams(@RequestParam List<Integer> id){
        return "Users ids:"+id;
    }

    // 3)
    // Handling @RequestParam with Map
    @GetMapping("/user3")
    public String getUsersByMap(@RequestParam Map<String, String> params) {
        return "Query Params: " + params;
    }

    // 4) Multiple query parameters:-
    @GetMapping("/user5")
    public String getAdd(@RequestParam int id1,@RequestParam int id2){
        return "Addition is:"+(id1+id2);
    }
}

//Here,
//?name=Akash&age=20 are Query Parameters.

// 1)
//  http://localhost:8080/api/users1?name=Akash&age=20
//If we do not specify age it takes the default value as 0.
// For example http://localhost:8080/api/users1?name=Akash -> for this the output is: 'User: Akash & Age:0'.

//2)
// http://localhost:8080/api/users2?id=1&id=2&id=3

// 3)
// http://localhost:8080/api/user3?name=Akash&age=20&city=Hyderabad

// 4) http://localhost:8080/api/user5?id1=10&id2=12
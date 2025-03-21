package com.example.HandlingHTTPRequests;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PathVariableController {

    // 1) Single Path variable:
    @GetMapping("/users1/{id}")
    public String getUserById(@PathVariable int id){
        return "User Id:"+id;
    }

    // 2) Multiple path variables:
    @GetMapping("/users2/{id}/orders/{ord}")
    public String getUserWithOrdersById(@PathVariable int id,@PathVariable int ord){
        return "User with Id:"+id+" has orders:"+ord;
    }

    // 3)Optional @PathVariable with Default Value
    @GetMapping({"/users3/{id}","/users3"})   // Supports both /users/{id} and /users
    public String getUsers(@PathVariable(required = false) Optional<Integer> id){
        return "User Id:"+id.orElse(0);
    }

    // 4) Addition of two numbers:
    @GetMapping("/users4/{id1}/users5/{id2}")
    public String get(@PathVariable int id1,@PathVariable int id2){
        return "Addition is:"+(id1+id2);
    }
}

// 1) http://localhost:8080/api/users1/10
// 2) http://localhost:8080/api/users2/10/orders/15
// 3) http://localhost:8080/api/users3/10 (or) to get default value -> use this: http://localhost:8080/api/users3
// 4) http://localhost:8080/api/users4/10/users5/12
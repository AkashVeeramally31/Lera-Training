package com.example.SpringWeb.Controller;

import com.example.SpringWeb.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Controller
//@RestController
//@RequestMapping("/api")
public class UserController {

    //Below code return the HTML file.
    //For this use URL:- http://localhost:8080/users
    @GetMapping("/users")
    public String getUsers(Model model) {
        List<User> users = Arrays.asList(
                new User(1, "Alice", "alice@example.com"),
                new User(2, "Bob", "bob@example.com")
        );

        model.addAttribute("users", users);
        return "users";  // Maps to users.html in templates folder
    }


    //To Return JSON instead of HTML follow the below code and include @RestController
    // and @RequestMapping:-
    //For this use URL as :- http://localhost:8080/api/users
//    @GetMapping("/users")
//    public List<User> getUsers() {
//        return Arrays.asList(
//                new User(1, "Alice", "alice@example.com"),
//                new User(2, "Bob", "bob@example.com")
//        );
//    }
}


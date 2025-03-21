package com.example.RESTAPI;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRESTController {
    List<User> list=new ArrayList<>();
    public UserRESTController(){
        list.add(new User(101,"Akash","akash@gmail.com"));
        list.add(new User(102,"Mani","mani@gmail.com"));
        list.add(new User(103,"Anand","anand@gmail.com"));
    }

    //Get
    @GetMapping
    public List<User> getAllUsers(){
        return list;
    }

    //Get by ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id){
        return list.stream()
                .filter(p->p.getId()==id)
                .findFirst()
                .orElse(new User(0,"Invalid Id","No email"));
    }
    //We use findFirst() because ,if there are same multiple items then there will be ambiguity or confusion.

    //Post
    @PostMapping
    public String createUser(@RequestBody User user){
        list.add(user);
        return user.getName()+" added successfully";
    }

    //Put (or) Update
    @PutMapping("/{id}")
    public String updateUser(@PathVariable int id,@RequestBody User updUser){
        for(User user:list){
            if(user.getId()==id){
                user.setName(updUser.getName());
                user.setEmail(updUser.getEmail());
                return user.getId()+" updated successfully";
            }
        }
        return "User not found";
    }

    //Delete
    @DeleteMapping("{id}")
    public String deleteUser(@PathVariable int id){
        list.removeIf(user-> user.getId()==id);
        return "User with "+id+" deleted successfully";
    }
}

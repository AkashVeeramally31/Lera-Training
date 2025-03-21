package com.example.DataValidation.Controller;


import com.example.DataValidation.DTO.UserRequest;
import com.example.DataValidation.Model.User;
import com.example.DataValidation.Service.UserService;
import com.example.DataValidation.exception.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    //Before adding Validation annotations
//    @PostMapping("/signup")
//    public ResponseEntity<User> saveUser(@RequestBody UserRequest userRequest){
//        return new ResponseEntity<>(service.saveUser(userRequest), HttpStatus.CREATED);
//    }

    //After adding Validation annotations i.e.., we need to @Valid to enforce validation.
    @PostMapping("/signup")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest){
        return new ResponseEntity<>(service.saveUser(userRequest), HttpStatus.CREATED);
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(service.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) throws UserNotFoundException {
        return ResponseEntity.ok(service.getUser(id));
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) throws UserNotFoundException{
        service.deleteUser(id);
        return "User with Id:"+id+" deleted successfully";
    }

    @PutMapping("/{id}")
    public String updateUser(@RequestBody @Valid UserRequest userRequest,@PathVariable int id)
            throws UserNotFoundException{
        service.updateUser(userRequest,id);
        return "User with Id:"+id+" Updated successfully";
    }
}

// 'UserNotFoundException' is included because we have created a custom exception.

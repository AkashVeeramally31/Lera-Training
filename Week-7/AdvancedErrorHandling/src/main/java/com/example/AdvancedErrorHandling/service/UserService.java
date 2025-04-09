package com.example.AdvancedErrorHandling.service;

import com.example.AdvancedErrorHandling.exception.UserNotFoundException;
import com.example.AdvancedErrorHandling.model.User;
import com.example.AdvancedErrorHandling.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;


    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public User getUserById(int id) {
        User user=repo.findById(id).orElse(null);
        if(user!=null){
            return user;
        }else{
            throw new UserNotFoundException("User with Id:"+id+" not found");
        }
    }

    public String addUser(User user) {
        repo.save(user);
        return "User added successfully";
    }

    public String updateUser(int id,User user1){
        User user=repo.findById(id).orElse(null);
        if(user!=null){
            user.setName(user1.getName());
            user.setAge(user1.getAge());
            repo.save(user);
            return "User with Id"+id+" updated successfully";
        }else{
            throw new UserNotFoundException("User with Id:"+id+" not found");
        }
    }

    public String deleteUser(int id) {
        User user=repo.findById(id).orElse(null);
        if(user!=null){
            repo.deleteById(id);
            return "User with Id:"+id+" deleted successfully";
        }else{
            throw new UserNotFoundException("User with Id:"+id+" not found");
        }
    }
}

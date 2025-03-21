package com.example.BCrypt_5.service;

import com.example.BCrypt_5.model.User;
import com.example.BCrypt_5.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;
    BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);

    public User saveUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));   // Now this encrypts the password.
        return repo.save(user);
    }
    // For example, give Post request, then you will get the encrypted password in the database or in the postman.
    // By this, no one can see the password in the database.
}

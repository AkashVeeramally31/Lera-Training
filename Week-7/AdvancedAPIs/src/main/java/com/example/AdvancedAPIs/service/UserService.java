package com.example.AdvancedAPIs.service;

import com.example.AdvancedAPIs.model.User;
import com.example.AdvancedAPIs.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;

    public Page<User> getUsers(int page, int size, String sortBy,String order) {
        Sort sort=order.equalsIgnoreCase("asc")?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        Pageable pageable=PageRequest.of(page,size,sort);
        return repo.findAll(pageable);
    }

    public Page<User> getUsersByAge(int age, int page, int size) {
        Pageable pageable=PageRequest.of(page,size);
        return repo.findByAge(age,pageable);
    }
}

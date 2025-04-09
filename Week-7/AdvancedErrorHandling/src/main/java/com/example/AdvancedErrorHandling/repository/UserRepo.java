package com.example.AdvancedErrorHandling.repository;

import com.example.AdvancedErrorHandling.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
}

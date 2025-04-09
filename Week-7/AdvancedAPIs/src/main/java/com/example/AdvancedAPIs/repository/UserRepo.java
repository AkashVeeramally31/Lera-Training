package com.example.AdvancedAPIs.repository;

import com.example.AdvancedAPIs.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    @Query("SELECT p FROM User p WHERE p.age= :age")
    Page<User> findByAge(@Param("age") int age, Pageable pageable);
}

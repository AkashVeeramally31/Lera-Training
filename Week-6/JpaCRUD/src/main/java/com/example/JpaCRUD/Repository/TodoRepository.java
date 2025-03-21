package com.example.JpaCRUD.Repository;

import com.example.JpaCRUD.Model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Integer> {
}

package com.example.AdvancedAPIs.controller;

import com.example.AdvancedAPIs.model.Book;
import com.example.AdvancedAPIs.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping
    public Page<Book> getAllBooks(
            @RequestParam(defaultValue = "0")int page,
            @RequestParam(defaultValue = "5")int size,
            @RequestParam(defaultValue = "id")String sortBy,
            @RequestParam(defaultValue = "asc")String order){
        return service.getAllBooks(page,size,sortBy,order);
    }
}

// GET http://localhost:8080/api/books?sortBy=name
// Sorts by name in default(ascending) order

// GET http://localhost:8080/api/books?sortBy=price&order=dsc
// Sorts by price in descending order
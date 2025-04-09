package com.example.AdvancedAPIs.controller;

import com.example.AdvancedAPIs.model.Product;
import com.example.AdvancedAPIs.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService service;

    // Get all products with pagination and sorting
    @GetMapping
    public Page<Product> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection) {

        return service.getAllProducts(page, size, sortBy, sortDirection);
    }

    // Get products by category with pagination
    @GetMapping("/category")
    public Page<Product> getProductsByCategory(
            @RequestParam String category,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return service.getProductsByCategory(category, page, size);
    }
}

// Returns the products in the sorted(Ascending) order of their price.
// GET http://localhost:8080/api/products?sortBy=price&sortDirection=asc

// Returns 3 products from the electronics category.
// http://localhost:8080/api/products/category?category=electronics&page=0&size=3
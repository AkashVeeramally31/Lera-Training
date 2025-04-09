package com.example.AdvancedErrorHandling.controller;

import com.example.AdvancedErrorHandling.model.Product;
import com.example.AdvancedErrorHandling.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> getAllProducts(){
        return service.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id){
        return service.getProductById(id);
    }

    @PostMapping
    public String addProduct(@RequestBody Product product){
        return service.addProduct(product);
    }

    @PutMapping("/{id}")
    public String updateProduct(@PathVariable int id,@RequestBody Product product){
        return service.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id){
        return service.deleteProduct(id);
    }
}

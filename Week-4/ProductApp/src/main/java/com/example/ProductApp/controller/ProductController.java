package com.example.ProductApp.controller;


import com.example.ProductApp.model.Product;
import com.example.ProductApp.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/fetchAll")
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(service.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        return ResponseEntity.ok(service.getProductById(id));
    }

    @PostMapping("/signup")
    public ResponseEntity<Product> addProduct(@RequestBody @Valid Product pro){
        return ResponseEntity.ok(service.addProduct(pro));
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id){
        service.deleteProduct(id);
        return "Product with Id:"+id+" deleted successfully";
    }

    @PutMapping("/{id}")
    public String updateProduct(@RequestBody @Valid Product pro,@PathVariable int id){
        service.updateProduct(pro,id);
        return "Product with Id:"+id+" updated successfully";
    }
}
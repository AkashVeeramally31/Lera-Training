package com.example.SpringWeb.Controller;

import com.example.SpringWeb.Model.Products;
import com.example.SpringWeb.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService prodser;

    @GetMapping("/products")
    public List<Products> Prod(){
        return prodser.getProd();   //Goes to ProductService class
    }
}

//To see the output Navigate to this URL:- http://localhost:8080/products

package com.example.SpringWeb.Controller;

import com.example.SpringWeb.Model.Products;
import com.example.SpringWeb.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService prodser;

    //Lists all products
    @RequestMapping("/products")
    public List<Products> Prod(){
        return prodser.getProd();   //Goes to ProductService class
    }


    //Lists only one product
    @GetMapping("/product/{prodId}")
    public Products getProductById(@PathVariable int prodId){
        return prodser.getProductById(prodId);
    }

    //Creates product
    @PostMapping("/addProd")
    public void addProduct(@RequestBody Products p){
        prodser.addProduct(p);
    }

    //Updates product
    @PutMapping("/updateProd")
    public void updateProduct(@RequestBody Products p){
        prodser.updateProd(p);
    }

    //Deletes Product
    @DeleteMapping("/delProd/{prodId}")
    public void delProduct(@PathVariable int prodId){
        prodser.delProd(prodId);
    }
}



//To see the output Navigate to this URL:- http://localhost:8081/products i.e.., to get all products.

//To get the particular product use:-  http://localhost:8081/product/101 i.e.., 'id'.

//To create new product use:- http://localhost:8081/addProd

//To update the existing product use:-  http://localhost:8081/updateProd

//To delete the product use:- http://localhost:8081/delProd/101 i.e.., 'id'
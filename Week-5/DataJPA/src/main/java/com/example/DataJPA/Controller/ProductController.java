package com.example.DataJPA.Controller;

import com.example.DataJPA.Model.Products;
import com.example.DataJPA.Repository.ProductRepo;
import com.example.DataJPA.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    //The below code is using the Service layer, but using JPA we implement using Repository layer.
//    @Autowired
//    ProductService prodser;
//
//    //Lists all products
//    @GetMapping()
//    public List<Products> Prod(){
//        return prodser.getProd();   //Goes to ProductService class
//    }
//
//
//    //Lists only one product
//    @GetMapping("/{prodId}")
//    public Products getProductById(@PathVariable int prodId){
//        return prodser.getProductById(prodId);
//    }
//
//    //Creates product
//    @PostMapping()
//    public void addProduct(@RequestBody Products p){
//        prodser.addProduct(p);
//    }
//
//    //Updates product
//    @PutMapping("")
//    public void updateProduct(@RequestBody Products p){
//        prodser.updateProd(p);
//    }
//
//    //Deletes Product
//    @DeleteMapping("/{prodId}")
//    public void delProduct(@PathVariable int prodId){
//        prodser.delProd(prodId);
//    }

    //Below code is using Repository layer.

    @Autowired
    private ProductRepo repo;

    @GetMapping()
    public List<Products> getProd(){
        return repo.findAll();
    }

    @GetMapping("/{prodId}")
    public Products getProdById(@PathVariable int prodId){
        return repo.findById(prodId).orElse(null);
    }

    @PostMapping()
    public String addProd(@RequestBody Products prod){
        repo.save(prod);
        return "Product Added successfully";
    }

    @PutMapping()
    public String updateProduct(@RequestBody Products prod){
        repo.save(prod);
        return "Product updated successfully";
    }

    @DeleteMapping("/{prodId}")
    public String deleteProd(@PathVariable int prodId){
        repo.deleteById(prodId);
        return "Product deleted successfully";
    }
}

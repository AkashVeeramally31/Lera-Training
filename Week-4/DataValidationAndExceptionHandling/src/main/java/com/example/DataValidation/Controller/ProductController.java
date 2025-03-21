package com.example.DataValidation.Controller;

import com.example.DataValidation.DTO.ProductRequest;
import com.example.DataValidation.DTO.UserRequest;
import com.example.DataValidation.Model.Product;
import com.example.DataValidation.Service.ProductService;
import com.example.DataValidation.exception.ProductNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping("/signup")
    public ResponseEntity<Product> saveProduct(@RequestBody @Valid ProductRequest pro){
        return new ResponseEntity<>(service.saveProduct(pro), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id)throws ProductNotFoundException {
        return ResponseEntity.ok((service.getProduct(id)));
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id) throws ProductNotFoundException{
        service.deleteProduct(id);
        return "Product with Id:"+id+" deleted successfully";
    }

    @PutMapping("/{id}")
    public String updateProduct(@RequestBody @Valid ProductRequest productRequest,@PathVariable int id)
            throws ProductNotFoundException{
        service.updateProduct(productRequest,id);
        return "Product with Id:"+id+" updated successfully";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.HEAD)
    public void check(@PathVariable int id){
        service.check(id);
    }
}

package com.example.JpaCRUD.Controller;

import com.example.JpaCRUD.Model.Product;
import com.example.JpaCRUD.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository repo;

    @PostMapping
    public String addProduct(@RequestBody Product product){
        repo.save(product);
        return "Product added successfully";
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        Product product=repo.findById(id).orElse(null);
        if(product!=null){
            return new ResponseEntity<>(product,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@RequestBody Product product,@PathVariable int id){
        Product product1=repo.findById(id).orElse(null);
        if(product1!=null){
            List<Product> products=repo.findAll();
            for(Product pro:products){
                if(id==pro.getId()){
                    pro.setBrand(product.getBrand());
                    pro.setModel(product.getModel());
                    pro.setPrice(product.getPrice());
                    pro.setCategory(product.getCategory());
                    repo.save(pro);
                }
            }
            return new ResponseEntity<>("Product with Id:"+id+" updated successfully",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("There is no product with Id:"+id,HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        Product product=repo.findById(id).orElse(null);
        if(product!=null){
            repo.deleteById(id);
            return new ResponseEntity<>("Product with Id:"+id+" deleted successfully",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("There is no product with Id:"+id,HttpStatus.NOT_FOUND);
        }
    }
}

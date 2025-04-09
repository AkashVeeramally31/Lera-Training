package com.example.AdvancedErrorHandling.service;

import com.example.AdvancedErrorHandling.exception.ProductNotFoundException;
import com.example.AdvancedErrorHandling.model.Product;
import com.example.AdvancedErrorHandling.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public List<Product> getAllProducts(){
        return repo.findAll();
    }

    public Product getProductById(int id){
        Product product=repo.findById(id).orElse(null);
        if(product!=null){
            return product;
        }else{
            throw new ProductNotFoundException("Product with Id:"+id+" not found");
        }
    }

    public String addProduct(Product product) {
        repo.save(product);
        return "Product added successfully";
    }

    public String updateProduct(int id,Product product){
        Product product1=repo.findById(id).orElse(null);
        if(product1!=null){
            product1.setName(product.getName());
            product1.setBrand(product.getBrand());
            product1.setPrice(product.getPrice());
            repo.save(product1);
            return "Product with Id:"+id+" updated successfully";
        }else{
            throw new ProductNotFoundException("Product with Id:"+id+" not found");
        }
    }

    public String deleteProduct(int id){
        Product product=repo.findById(id).orElse(null);
        if(product!=null){
            repo.deleteById(id);
            return "Product with id:"+id+" deleted successfully";
        }else{
            throw new ProductNotFoundException("Product with id:"+id+" not found");
        }
    }
}

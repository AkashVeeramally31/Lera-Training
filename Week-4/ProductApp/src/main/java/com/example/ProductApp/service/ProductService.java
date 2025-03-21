package com.example.ProductApp.service;

import com.example.ProductApp.exception.ProductNotFoundException;
import com.example.ProductApp.model.Product;
import com.example.ProductApp.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repo;

    public Product addProduct(Product pro){
        return repo.save(pro);
    }
    public List<Product> getAllProducts(){
        return repo.findAll();
    }
    public Product getProductById(int id){
        return repo.findById(id).orElseThrow(()->
                new ProductNotFoundException("Product with Id:"+id+" not found"));
    }

    public void deleteProduct(int id) {
        Product pro=repo.findById(id).orElseThrow(()->
                new ProductNotFoundException("There is not product with Id:"+id));
        repo.deleteById(id);
    }

    public void updateProduct(@Valid Product pro, int id) {
        Product expro=repo.findById(id).orElseThrow(()->
                new ProductNotFoundException("Product with Id:"+id+" not found"));
        expro.setName(pro.getName());
        expro.setPrice(pro.getPrice());
        expro.setStock(pro.getStock());
        repo.save(expro);
    }
}

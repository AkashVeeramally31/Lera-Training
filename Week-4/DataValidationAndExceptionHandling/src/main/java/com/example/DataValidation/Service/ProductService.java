package com.example.DataValidation.Service;

import com.example.DataValidation.DTO.ProductRequest;
import com.example.DataValidation.Model.Product;
import com.example.DataValidation.Repository.ProductRepository;
import com.example.DataValidation.exception.ProductNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repo;

    public List<Product> getAllProducts(){
        return repo.findAll();
    }

    public Product saveProduct(ProductRequest productRequest){
        Product product=Product.build(0,productRequest.getName(), productRequest.getPrice(),
                productRequest.getStock(), productRequest.getBrand(),productRequest.getCategory());
        return repo.save(product);
    }

//    public Product getProduct(int id){
//        return repo.findById(id).orElse(null);
//    }


    public Product getProduct(int id) throws ProductNotFoundException{
        Product product=repo.findById(id).orElse(null);
        if(product!=null){
            return product;
        }else{
            throw new ProductNotFoundException("Product with Id:"+id+" not found");
        }
    }

    public void deleteProduct(int id) throws ProductNotFoundException{
        //repo.deleteById(id);
        Product product=repo.findById(id).orElse(null);
        if(product!=null){
            repo.deleteById(id);
        }else{
            throw new ProductNotFoundException("There is no product with Id:"+id);
        }
    }

    public void updateProduct(@Valid ProductRequest productRequest, int id)throws ProductNotFoundException {
        Product product=repo.findById(id).orElse(null);
        if(product!=null) {
            product = Product.build(id, productRequest.getName(), productRequest.getPrice(),
                    productRequest.getStock(), productRequest.getBrand(), productRequest.getCategory());
            repo.save(product);
        }else{
            throw new ProductNotFoundException("Product with Id:"+id+" is not available");
        }
    }

    public void check(int id){
        Product product=repo.findById(id).orElse(null);
        if(product!=null){
            throw new ResponseStatusException(HttpStatus.FOUND);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}

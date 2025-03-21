package com.example.SpringWeb.Service;

import com.example.SpringWeb.Model.Products;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {
    List<Products> prod= Arrays.asList(new Products(101,"Iphone 16",80000),
            new Products(102,"Samsung S24",98000),
            new Products(103,"Google Pixel",75000));

    public List<Products> getProd(){
        return prod;
    }
}

package com.example.DataJPA.Service;

import com.example.DataJPA.Model.Products;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {
//    List<Products> prod= Arrays.asList(new Products(101,"Iphone 16",80000),
//            new Products(102,"Samsung S24",98000),
//            new Products(103,"Google Pixel",75000));
    //Since Arrays are immutable i.e.., we cannot create new item, so we store in ArrayList.

    List<Products> prod= new ArrayList<>(Arrays.asList(new Products(101,"Iphone 16",80000),
            new Products(102,"Samsung S24",98000),
            new Products(103,"Google Pixel",75000)));

    public List<Products> getProd(){
        return prod;
    }

    //If item not present, it will returns the No item.
    public Products getProductById(int prodId){
        return prod.stream().
                filter(p-> p.getProdID()==prodId)
                .findFirst().orElse(new Products(100,"No item",0));
    }
    public void addProduct(Products p){
        prod.add(p);
    }

    public void updateProd(Products p) {
        int index=0;
        for(int i=0;i< prod.size();i++){
            if(prod.get(i).getProdID()==p.getProdID()){
                index=i;
            }
        }
        prod.set(index,p);
    }

    public void delProd(int prodId) {
        int index=0;
        for(int i=0;i<prod.size();i++) {
            if(prod.get(i).getProdID()==prodId){
                index=i;
            }
        }
        prod.remove(index);
    }
}

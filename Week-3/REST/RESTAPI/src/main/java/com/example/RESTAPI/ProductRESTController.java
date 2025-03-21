package com.example.RESTAPI;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/api/products")
public class ProductRESTController {
    List<Product> prod=new ArrayList<>(Arrays.asList(
            new Product(101,"Laptop",40000),
            new Product(102,"Mobile",1500),
            new Product(103,"TV",20000),
            new Product(104,"AC",30000)));

    @GetMapping()
    public List<Product> getProd(){
        return prod;
    }

    @GetMapping("/{id}")
    public Product getProdById(@PathVariable int id){
        return prod.stream()
                .filter(p->p.getId()==id)
                .findFirst()
                .orElse(new Product(0,"No item",0));
    }

    @PostMapping()
    public String addProd(@RequestBody Product p){
        prod.add(p);
        return p.getName()+" added successfully";
    }

    @PutMapping("/{id}")
    public String updateProd(@PathVariable int id,@RequestBody Product pro){
        for(Product p:prod){
            if(p.getId()==id){
                p.setName(pro.getName());
                p.setPrice(pro.getPrice());
                return "Product with "+p.getId()+" updated successfully";
            }
        }
        return "Item not found";
    }

    @DeleteMapping("/{id}")
    public String deleteProd(@PathVariable int id){
        prod.removeIf(p-> p.getId()==id);
        return "User with "+id+" deleted successfully";
    }

    @PatchMapping("/{id}")
    public String partiallyUpdateProd(@PathVariable int id, @RequestBody Product patchProduct) {
        Product existingProduct = prod.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);

        if (existingProduct != null) {
            if (patchProduct.getName() != null) {
                existingProduct.setName(patchProduct.getName());
            }
            if (patchProduct.getPrice() != 0) {
                existingProduct.setPrice(patchProduct.getPrice());
            }
            return "Product with " + id + " partially updated successfully";
        } else {
            return "Product not found";
        }
    }

    // HEAD - Check if a product exists (only headers, no body)
    @RequestMapping(value = "/{id}", method = RequestMethod.HEAD)
    public void headProduct(@PathVariable int id) {
        Product pr=prod.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
        if(pr!=null) {
            // If the product exists, respond with 200 OK
            // Do nothing in the body, just return the headers
        } else {
            // If the product doesn't exist, respond with 404 Not Found
            // This will let the client know the resource doesn't exist
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
    }
}
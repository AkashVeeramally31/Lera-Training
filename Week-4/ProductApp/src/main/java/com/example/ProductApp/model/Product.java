package com.example.ProductApp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name shouldn't be null")
    private String name;

    @NotNull(message = "Price can't be null")
    @Min(value = 1,message = "Price must be at least 1")
    private int price;
    //private String brand;

    @Min(value = 0,message = "Stock cannot be negative")
    private int stock;
}

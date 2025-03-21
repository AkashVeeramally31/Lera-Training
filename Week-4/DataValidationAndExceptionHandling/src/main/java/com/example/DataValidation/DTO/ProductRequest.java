package com.example.DataValidation.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class ProductRequest {

    @NotNull(message = "name shouldn't be null")
    private String name;

    @NotNull(message = "Price can't be null")
    @Min(value = 1,message = "Price must be at least 1")
    private double price;

    @Min(value = 0,message = "Stock can't be negative")
    private int stock;

    @NotNull(message = "Brand can't be null")
    private String brand;

    @NotNull(message = "Must be under some category")
    private String category;
}

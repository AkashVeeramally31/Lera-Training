package com.example.AdvancedErrorHandling.exception;

// This class defines a custom exception when a product is not found.

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}

// Extends RuntimeException → So that it can be thrown during API execution.
// Custom message → Passed when the exception is thrown.

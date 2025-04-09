package com.example.AdvancedErrorHandling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdvancedErrorHandlingApplication {
	public static void main(String[] args) {
		SpringApplication.run(AdvancedErrorHandlingApplication.class, args);
	}
}

// Custom Exception Handling → ProductNotFoundException and UserNotFoundException
// Global Exception Handling → GlobalExceptionHandler
// Custom Error Response → JSON structure for debugging
// Better API Error Handling → Structured messages
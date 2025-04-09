package com.example.AdvancedAPIs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import static org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO;

@EnableSpringDataWebSupport(pageSerializationMode = VIA_DTO) //For a stable JSON structure, use this annotation(Optional).
@SpringBootApplication
public class AdvancedApIsApplication {
	public static void main(String[] args) {
		SpringApplication.run(AdvancedApIsApplication.class, args);
	}
}

// When working with large datasets in REST APIs, loading all records at once can cause performance
// issues. To handle this efficiently: - pagination, sorting, and filtering are used to optimize data
// retrieval and improve response times.
// So we implement Pagination, sorting, and filtering in this application.
// Pagination helps in handling large datasets efficiently by retrieving data in smaller chunks.
// And the page number starts from '0'.
// Sorting allows ordering results based on specified fields.
// Filtering refines data retrieval based on query parameters.
// Combining these techniques ensures optimized performance in REST APIs.
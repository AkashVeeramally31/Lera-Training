package com.example.SpringAOP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAOPApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAOPApplication.class, args);
	}

}

// First load the data to get all the data in the database and in the table if and only if, the data
// is not available in the table.
// url:- http://localhost:8080/load
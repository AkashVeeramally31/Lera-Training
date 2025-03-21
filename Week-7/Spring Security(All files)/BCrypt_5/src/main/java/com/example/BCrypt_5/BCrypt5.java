package com.example.BCrypt_5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BCrypt5 {
	public static void main(String[] args) {
		SpringApplication.run(BCrypt5.class, args);
	}

}

// For any Post-request, make sure to include type(now Basic Auth), username and password in the 'Authorization' section
// Username: Mani
// Password: mani@123
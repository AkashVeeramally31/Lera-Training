package com.example.SpringWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebApplication.class, args);
	}

}

//Difference Between @RestController and @Controller
//	Annotation						Purpose
//	@Controller			Returns an HTML view using a template engine like Thymeleaf.
//	@RestController		Returns JSON data (useful for RESTful APIs).



//Files connected are:- ProductController, Products, ProductService which is done using @RestController.

//Files connected are:- UserController, User, (users.html in resources/templates), which is done using
// @Controller which includes Thymeleaf.
//Thymeleaf – A template engine to display dynamic data in an HTML file.
//To include Thymeleaf, add dependency of Thymeleaf in pom.xml.
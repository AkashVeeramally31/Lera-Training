package com.example.DataValidation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataValidationApplication {
	public static void main(String[] args) {
		SpringApplication.run(DataValidationApplication.class, args);
	}
}


// For Data validation we need to add dependencies of :- web, JPA,H2,Lambok, 'Validation'.

// First refer User.java of Model package.

// When we run the application after adding required Validation annotations,if the 'PostRequest' doesn't match with the
// requirements it will result in '400 Bad Request' and in the console we will get the
// 'MethodArgumentNotValidException' which we cannot understand.
// So in this case we use the concept of 'ExceptionHandling'.

// We will create an ExceptionHandling in such a way that whenever we get this
// exception('MethodArgumentNotValidException') then we gather all the error messages which we included in the
// UserRequest class, and give it to the user.

// So for this we create a new package called Advice.
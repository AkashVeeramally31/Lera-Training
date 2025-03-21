package com.example.SpringSecurityIntro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityIntroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityIntroApplication.class, args);
	}

}
// We can set the username and password in the application.properties (or) application.yml file.

// To get the output in the postman: -
// send url:- http://localhost:8080/hello then you will get 401 Unauthorized because you have not
// the resource is not authorized i.e., not given the username and password.
// So specify username and password in the: -
// 'Authorization' and select 'type': - for this select 'Basic Auth'
// And then give username and password.
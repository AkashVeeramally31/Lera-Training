package com.example.SpringSecurityIntro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityIntroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityIntroApplication.class, args);
	}

}

// In the spring boot security project, we need to add dependency of spring security in pom.xml
// After opening it in the IntelliJ, when we run the project and after opening it in the chrome, you
// will see a default login page which includes username and password.
// By default, username is:- user
// password is default generated password which will be available in the console.
// Sample example: -
// Using generated security password: 8e742c20-4b5b-43af-83a9-e758fb8f8723
// After giving username and password, when we click 'login,' it will give error because we don't have
// a redirected page to go.

// By default, spring boot security gives default login and logout pages i.e..,
// for login page url: http://localhost:8080
// for logout page url: http://localhost:8080/logout

// Note: - for every login, there must be a successive logout, otherwise when we access the web page
// second time, it will throw an error.

package com.example.DataJPA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataJPA {

	public static void main(String[] args) {
		SpringApplication.run(DataJPA.class, args);
	}

}


//To include h2 driver name, we need to add this in application.yml where database name is:"myDB" and
// driver class name is org.h2.Driver.
//spring:
//datasource:
//url: jdbc:h2:mem:myDB
//driverClassName: org.h2.Driver


//To see the database open browser and navigate to http://localhost:8081/h2-console
//In that username and password are created in application.yml file, using that username and password we can
// connect to the h2 database. And just do:-
//1) Test Connection:- After the msg 'Test successful'
//2) Connect:- And the database will be appeared.



//To see the backend of CRUD include this in application.yml
//jpa:
//show-sql: true

//To see the actual values include this in application.yml
//logging:
//level:
//org:
//hibernate:
//SQL: DEBUG
//orm.jdbc.bind: TRACE

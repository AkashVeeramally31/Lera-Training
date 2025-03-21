package com.example.SpringActuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringActuatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringActuatorApplication.class, args);
	}

}

//Files connected are:- UserEntity and RESTFulController

//HelloController and CustomEndpoint are individual files.

//To get actuator details: navigate to different url's such as:-
// http://localhost:8081/actuator/health
// http://localhost:8081/actuator/info
// http://localhost:8081/actuator/metrics
// http://localhost:8081/actuator/mappings
package com.example.SpringBootProfilesAndConfigurations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootProfilesAndConfigurationsApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootProfilesAndConfigurationsApplication.class, args);
	}
}

// If the data is already available in the table, you will get the 'duplicate key error', so delete the data
// every time or insert the data with different id.

// Spring Boot Profiles allow developers to manage multiple environments (dev, test, prod, etc.) by
// loading different configurations for each environment. This helps in separating environment-specific
// settings like database credentials, logging levels, API keys, and other configurations.

// Why Use Spring Boot Profiles?
// ✅ Manage different environment configurations without modifying code.
// ✅ Avoid hardcoding environment variables in the application.
// ✅ Enable or disable specific components in different environments.
// ✅ Helps in deploying the application to different environments easily.


// Spring Boot provides 3 ways to define profile-based configurations:
// 1️⃣ Using application.properties or application.yml
// 2️⃣ Using @Profile annotation in code.
// 3️⃣ Using command-line arguments or environment variables


// Spring Boot Profile Hierarchy:-
// If the same property exists in multiple locations, Spring Boot loads them in the following
// order (highest to lowest priority):
// 1️⃣ Command-line arguments (--spring.profiles.active=prod)
// 2️⃣ Environment variables (SPRING_PROFILES_ACTIVE=prod)
// 3️⃣ Application properties (application-{profile}.properties)
// 4️⃣ Default properties (application.properties)
// The highest priority setting is used!
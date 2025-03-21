package com.example.Authentication.Securing.APIs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
                .csrf(csrf-> csrf.disable()) // Disable CSRF for APIs (not recommended for web apps)
                .authorizeHttpRequests(auth->auth
                        .requestMatchers("/api/public").permitAll()         // Public endpoint
                        .requestMatchers("/api/admin").hasRole("Admin")     // Restricted to Admin.
                        .requestMatchers("/api/user").hasAnyRole("User","Admin")    // Accessible by USER & ADMIN
                        .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults()) // Enables form login in the browser
                .httpBasic(Customizer.withDefaults()) // Enable Basic Authentication
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user= User.withDefaultPasswordEncoder()
                .username("user")
                .password("user123")
                .roles("User")
                .build();

        UserDetails admin=User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin123")
                .roles("Admin")
                .build();

        return new InMemoryUserDetailsManager(user,admin);
    }

    // http://localhost:8080/logout :- Automatically logout from the session.
}

// In postman, if we give the url as http://localhost:8080/api/admin and credentials as username: 'user'
// and password: 'user123', then we get '403 forbidden' because user does not have access to admins url.
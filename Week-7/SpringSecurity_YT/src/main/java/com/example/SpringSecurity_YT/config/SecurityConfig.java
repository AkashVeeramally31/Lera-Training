package com.example.SpringSecurity_YT.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(customizer -> customizer.disable()); //Disabling CSRF token
//        http.authorizeHttpRequests(request -> request.anyRequest().authenticated());    //For authentication
//        // http.formLogin(Customizer.withDefaults());      // For getting form login in the browser
//        http.httpBasic(Customizer.withDefaults());      // For getting correct output in the Postman.
//
//        // Making API Stateless i.e., every time we run, we get a different session id. Before this we have
//        // got the same session id after running so many times.
//        // Only we get different session id in Postman, to get different session id in browser
//        // we need to comment line 19.
//        // By commenting line 19, we get the pop-up not the login form.
//        http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//        return http.build();


        // Also written as,
        return http
                .csrf(customizer -> customizer.disable())
                .authorizeHttpRequests(request -> request.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }
}

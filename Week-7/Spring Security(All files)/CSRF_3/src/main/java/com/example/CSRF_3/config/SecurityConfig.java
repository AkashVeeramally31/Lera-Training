package com.example.CSRF_3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

// This file is for Disabling CSRF token, and also this code will create login popup, not the login form.
// Also, logout page will not work because we have not added the 'logout filter'.

//When to Disable CSRF:
// You might want to disable CSRF protection in the following scenarios:
// 1) API Development (especially REST APIs):
// CSRF protection is unnecessary for stateless REST APIs since they don't rely on
// session cookies for authentication. Token-based authentication (e.g., JWT tokens) is used instead.
// 2) Testing and Development Environment:
// During development or testing, disabling CSRF can make debugging easier, but it should never
// be done in production without other security measures in place.
// 3) Publicly Accessible Resources:
// For endpoints that are publicly accessible and don't perform sensitive actions (e.g., retrieving
// public data), CSRF protection might not be needed.
// 4) Authentication with External Systems:
// When integrating with third-party authentication systems or OAuth2 flows that handle CSRF protection
// themselves.

// How to Disable CSRF in Spring Boot: There are two ways
// i) using lambda
// ii) imperative way
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // i) using lambda
//        http.csrf(customizer->customizer.disable());
//        http.authorizeHttpRequests(request->request.anyRequest().authenticated());
//        http.httpBasic(Customizer.withDefaults());
//        http.sessionManagement(session->
//                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        // The above code can be written using lambda expression
        http.csrf(customizer -> customizer.disable())
                .authorizeHttpRequests(request -> request.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        // This will disable CSRF token and makes API Stateless. Whenever we send the request,
        // new session id is created.
        // Now by creating this file, we don't need to include CSRF token in the headers for post-request.


        // Don't use imperative, prefer using lambda
        // ii) Using imperative
        /*
         * Customizer<CsrfConfigurer<HttpSecurity>> custCsrf = new
         * Customizer<CsrfConfigurer<HttpSecurity>>() {
         *
         * @Override public void customize(CsrfConfigurer<HttpSecurity> configurer) {
         *
         * configurer.disable(); } };
         *
         * Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.
         * AuthorizationManagerRequestMatcherRegistry> custHttp = new
         * Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.
         * AuthorizationManagerRequestMatcherRegistry>() {
         *
         * @Override public void customize(
         * AuthorizeHttpRequestsConfigurer<HttpSecurity>.
         * AuthorizationManagerRequestMatcherRegistry registry) {
         * registry.anyRequest().authenticated();
         *
         * } };
         *
         * http.authorizeHttpRequests(custHttp); http.csrf(custCsrf);
         */
        return http.build();
    }
}

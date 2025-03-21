package com.example.WorkingWithDB_4.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


// Here we will get the login popup not the login form and also remember logout will not work because we
// have not used 'logout filter'
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(customizer -> customizer.disable())
                .authorizeHttpRequests(request -> request.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }

    // The below method will not read username and password from the application.yml file, but it will take
    // static data which is not acceptable, so we create a dynamic 'UserDetailsService' class which takes
    // values form the database.
//    @Bean
//    public UserDetailsService userDetailsService(){
//
//        UserDetails user= User.withDefaultPasswordEncoder()
//                              .username("Akash")
//                              .password("Ak@123")
//                              .roles("USER").build();
//
//        UserDetails admin= User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("Admin@123")
//                .roles("ADMIN").build();
//
//        return new InMemoryUserDetailsManager(user,admin);
//    }

    @Autowired
    private UserDetailsService userDetailsService;

    // Dynamic class that takes values(username and password) from a database.
    @Bean
    public AuthenticationProvider authProvider(){
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        return provider;
    }
}

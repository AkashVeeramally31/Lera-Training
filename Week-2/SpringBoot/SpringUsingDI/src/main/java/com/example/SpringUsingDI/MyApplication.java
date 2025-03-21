package com.example.SpringUsingDI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
//import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) {
        ApplicationContext con =SpringApplication.run(MyApplication.class, args);
        Dev dev = con.getBean(Dev.class);
        dev.build();
    }
}


//Java files attached to this program are:-
//Dev, Laptop, Desktop, Computer.
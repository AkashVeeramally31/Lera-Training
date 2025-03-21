package com.example.sample;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
//If we use @Primary it has the highest preference to execute.
public class Laptop implements Computer{
    @Override
    public void compile() {
        System.out.println("Compiling with 404 Bugs..");
    }
}

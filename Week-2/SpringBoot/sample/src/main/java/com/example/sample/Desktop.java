package com.example.sample;

import org.springframework.stereotype.Component;

@Component
public class Desktop implements Computer{
    public void compile(){
        System.out.println("Compiling with 404 Bugs but faster..");
    }
}

package com.example.SpringUsingDI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Dev {
    private final Computer comp;

    //Constructor Injection
    public Dev(Computer comp) {
        this.comp = comp;
    }
    public void build(){
        //As we have used @Primary for Laptop, so it will execute the compile() method of Laptop class.
        comp.compile();
        System.out.println("Working on Awesome project");
    }
}


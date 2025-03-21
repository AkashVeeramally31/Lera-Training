package com.example.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Dev {
    @Autowired

    @Qualifier("desktop")

    //If we create object of Laptop it will execute method of Laptop
    //private Laptop lap;

    //If we create object of Desktop it will execute method of Desktop
    //private Desktop desk;

    //If we create object of Computer it will be in confusion to execute method of which class i.e..,
    private Computer comp;
    public void build(){
        //lap.compile();
        //desk.compile();
        comp.compile(); //it results in error.
        //To correctly execute the code we use another annotation called @Qualifier("class-name) which gives the
        // preference to execute method of which class.
        System.out.println("Working on Awesome project");
    }
}


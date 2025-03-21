package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {

        ApplicationContext con=new ClassPathXmlApplicationContext("spring.xml");
        //Calls automatically two constructors because here the objects are created in 'spring.xml'.

        Dev obj=(Dev) con.getBean("dev");
        //obj.setAge(20);
        //to set the 'age', we can also do using spring in 'spring.xml' using the 'property' tag for dev
        // object. This is called Setter Injection

        //to set the 'age', we can also do using spring in 'spring.xml' using the 'constructor-arg' tag for dev
        // object. This is called Constructor Injection

        //To get the age ,we will print it.
        System.out.println(obj.getAge());
        obj.compile();
    }
}
//This works for Primitive types i.e.., 'age' is an Integer value. so for Objects we need to create same setters
// and getters for Setter Injection and constructor for Constructor injection.

//This file maps with Dev,Laptop,spring.xml.
package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args){
        ApplicationContext con=new ClassPathXmlApplicationContext("spring.xml");
        Dev obj=(Dev)con.getBean("dev");
        //Also can be written as :- Dev obj=con.getBean(Dev.class);
        obj.display();
    }
}

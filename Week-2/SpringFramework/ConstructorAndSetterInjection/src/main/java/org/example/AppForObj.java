package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppForObj {
    public static void main(String[] args){
        ApplicationContext con=new ClassPathXmlApplicationContext("springObj.xml");
        DevObj obj=(DevObj)con.getBean("devObj");
        obj.compile();
    }
}

//This works for Objects.
//This file maps with DevObj,LaptopObj,springObj.xml.
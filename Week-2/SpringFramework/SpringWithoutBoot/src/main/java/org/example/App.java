package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args ) {
//        Dev dev=new Dev();
//        dev.display();
        //But we don't want to create the object, so we use spring.

        //ApplicationContext    //Throws an error because we don't have any dependencies for spring, so we need
                                // to add the dependencies in pom.xml
        //To add dependencies we need to go to 'mvnrepo' in that search for 'spring context' copy the code for
        // maven and paste it

        //Now we got the dependencies.

//        ApplicationContext con=new ClassPathXmlApplicationContext();
//        Dev obj=con.getBean(Dev.class);
//        obj.display();
        //The above code gives an error because we don't have xml file for configuration. so we will create an xml
        // file in 'resources'.


//        ApplicationContext con=new ClassPathXmlApplicationContext("spring.xml");
//        Dev obj=con.getBean(Dev.class);
//        obj.display();

        //For above code:- Now we have an xml file but we have not configured it so again it will throw an error.


        ApplicationContext con=new ClassPathXmlApplicationContext("spring.xml");
        Dev obj=(Dev)con.getBean("dev");
        obj.display();
        //Now we will get the output.

        //For above code we are passing "dev" to getBean because the id for bean tag is "dev" and getBean()
        // returns an object so we are typecasting with 'Dev'.

        //ApplicationContext con=new ClassPathXmlApplicationContext("spring.xml"); :- As we execute this line
        // it will go to spring.xml and create the objects of class that are present in spring.xml file.
    }
}

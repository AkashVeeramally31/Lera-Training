package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Laptop laptop=new Laptop();
        laptop.setRam(128);
        laptop.setBrand("Asus");
        laptop.setModel("Rog");

        Alien alien=new Alien();
        alien.setAid(1);
        alien.setAname("Akash");
        alien.setTech("Java");
        alien.setLaptop(laptop);

        SessionFactory sf=new Configuration()
                .addAnnotatedClass(org.example.Alien.class)
                .configure()
                .buildSessionFactory();
        Session session=sf.openSession();
        Transaction transaction=session.beginTransaction();

        // If creating first time uncomment the below line, otherwise it throws an error for primary key.
        //session.persist(alien);

        //Fetching data
        Alien a2=session.get(Alien.class,1);
        System.out.println(a2);

        transaction.commit();
        session.close();
        sf.close();
    }
}

// Primary example of @Embeddable is that storing other information in a class by extending another class.
// For example, we have one class student , and we want to store address of student, so we create another
// class called address which has specific parameters such as house-no, flat-no, street, landmark, pin code.
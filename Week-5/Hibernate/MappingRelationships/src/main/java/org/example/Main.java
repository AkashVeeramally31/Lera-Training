package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;


// OneToOne, OneToMany and ManyToOne mappings are done in the Main.java, Alien.java and Laptop.java
// ManyToOne mapping is done in StudentMain.java, Student.java, StudentAddress.java
public class Main {
    public static void main(String[] args) {
        Laptop l1=new Laptop();
        l1.setLid(101);
        l1.setRam(16);
        l1.setBrand("Asus");
        l1.setModel("Rog");

        Laptop l2=new Laptop();
        l2.setLid(102);
        l2.setRam(32);
        l2.setBrand("Dell");
        l2.setModel("XPS");

        Alien alien=new Alien();
        alien.setAid(1);
        alien.setAname("Akash");
        alien.setTech("Java");
        //alien.setLaptop(l1);
        alien.setLaptops(Arrays.asList(l1,l2));

        l1.setAlien(alien);
        l2.setAlien(alien);

        // Here we need to add annotated class of Laptop also because we are using it has an Entity.
        SessionFactory sf=new Configuration()
                .addAnnotatedClass(org.example.Alien.class)
                .addAnnotatedClass(org.example.Laptop.class)
                .configure()
                .buildSessionFactory();
        Session session=sf.openSession();
        Transaction transaction=session.beginTransaction();

        // First we need to persist the changes of Laptop because it is a parent table now.
        session.persist(l1);
        session.persist(l2);
        session.persist(alien);

        transaction.commit();
        session.close();
        sf.close();
        System.out.println("\uD83D\uDD25"+"\uD83D\uDD25"+"\uD83D\uDD25"); //Prints fire '🔥'.
    }
}
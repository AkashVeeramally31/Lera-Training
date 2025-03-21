package org.example;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainAlien {
    public static void main(String[] args) {
        Alien alien=new Alien();
        alien.setAid(1);
        alien.setAname("Akash");
        alien.setTech("Java");
        SessionFactory sf=new Configuration()
                .addAnnotatedClass(org.example.Alien.class)
                .configure()
                .buildSessionFactory();

        Session session=sf.openSession();
        Transaction transaction=session.beginTransaction();

        //Saving data
        session.persist(alien);

        transaction.commit();
        session.close();
        sf.close();
    }
}
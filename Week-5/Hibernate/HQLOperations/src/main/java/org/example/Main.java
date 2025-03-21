package org.example;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sf=new Configuration()
                .addAnnotatedClass(org.example.Laptop.class)
                .configure()
                .buildSessionFactory();
        Session session=sf.openSession();
        //Transaction transaction=session.beginTransaction();

        // Fetching the data:- since we are fetching the data, then we don't need 'Transaction' also,
        // so we comment it.

        // Fetching data using get() method by passing (class file and id).
        // Laptop l1=session.get(Laptop.class,102);
        // System.out.println(l1);

        // If we want to fetch the data by another field, then we use HQL(Hibernate Query Language) because we
        // don't have inbuilt methods for other fields other than a primary key.
        // Hibernate Query Language (HQL) is an object-oriented query language similar to SQL but operates
        // on Java objects instead of database tables.
        // Fetching all records from db:-
        // SQL-> Select * from table_name
        // HQL-> from class_name i.e...,:- using 'Query' interface.
        // Query query=session.createQuery("from Laptop");
        // System.out.println(query.getResultList());

        // Fetching data by name or other fields. For strings, we must enclose in single quotes ''.
        // Query query=session.createQuery("from Laptop where brand='Asus'");
        // Query query=session.createQuery("from Laptop where ram=32");
        // System.out.println(query1.getResultList());


        // If we want to pass the parameter from outside then:-
        // String brand="Asus";
        // Query query=session.createQuery("from Laptop where brand=?1"); // OR ("from Laptop brand like ?1")
        // query.setParameter(1,brand);
        // System.out.println(query.getResultList());


        // If we want to fetch only one specific column then:-'
        // Query query=session.createQuery("select model from Laptop where brand like 'Asus'");
        // System.out.println(query.getResultList());

        // If we want to fetch multiple columns then:-
        Query query=session.createQuery("select ram,brand, model from Laptop where brand like 'Asus'");
        List<Object[]> laptops=query.getResultList();
        for(Object[] data:laptops){
            System.out.println(data[0] +" "+data[1]+" "+data[2]);
        }

        //transaction.commit();
        session.close();
        sf.close();
    }
}
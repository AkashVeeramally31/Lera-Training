package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class GetVSLoadMain {
    public static void main(String[] args){
        SessionFactory sf=new Configuration()
                .addAnnotatedClass(org.example.Laptop.class)
                .configure()
                .buildSessionFactory();
        Session session=sf.openSession();

        // get() method
        // Laptop laptop=session.get(Laptop.class,102);
        // System.out.println(laptop);

        // If we don't print the object, then in the console, hibernate will generate the select query for line 17.
        // But if we use load() then in the console, hibernate will not generate any select query.
        // load() will generate the select query only, when we print the object.

        // Laptop laptop=session.load(Laptop.class,102);
        // Since load() method is deprecated hibernate introduced a new method called byId().getReference()
        // and this works same as load().
        Laptop laptop=session.byId(Laptop.class).getReference(102);

        // get() is best example for Eager fetching/loading.
        // load() (OR) byId().getReference() is best example for Lazy fetching/loading.

        session.close();
        sf.close();
    }
}
// Fetching determines how Hibernate loads related entities from the database when executing a query.
// Two types:-
// 1) Lazy Fetching : Loads related entities only when needed (default).
// 2) Eager Fetching : Loads related entities immediately with the parent entity.

// Example:-
// get() → Eager Loading (Direct DB hit).
// load() → Lazy Loading (Proxy object, DB hit only when needed).
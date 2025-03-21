package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Level2Cache {
    public static void main(String[] args){
        SessionFactory sf=new Configuration()
                .addAnnotatedClass(org.example.Laptop.class)
                .configure()
                .buildSessionFactory();
        Session session=sf.openSession();

        // Hibernate will have Level-1 cache inside it.
        Laptop l1=session.get(Laptop.class,102);
        System.out.println(l1);
        // Laptop l2=session.get(Laptop.class,102);
        // System.out.println(l2);
        // Select query will be generated only once because the Level-1 cache is present in the Hibernate.

        session.close();

        Session session1=sf.openSession();

        Laptop l2=session1.get(Laptop.class,102);
        System.out.println(l2);
        // Now select query will be generated again, because the new session has started.
        // To avoid this, we use Level-2 cache by including outside libraries such as EhCache.
        // For this, we need to add two dependencies in the pom.xml file, one is EhCache, and
        // the other is JCache. Also add dependency management of jaxb-runtime
        // Include these dependencies while only running this program because it will not allow other
        // programs to run successfully, and after finishing this program make sure to comment
        // those 3 dependencies:-
        // 1) jaxb-runtime in dependency management
        // 2) hibernate-jcache in dependencies
        // 3) ehcache in dependencies

        // To run successfully, add another annotation above Laptop class called @Cacheable annotation.
        // After adding run the program and will get the correct output.
        // If you are not getting the output: go to File → Invalidate Caches / Restart → Invalidate and Restart.

        session1.close();
        sf.close();
    }
}

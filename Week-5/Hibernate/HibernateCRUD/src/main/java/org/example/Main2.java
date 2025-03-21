package org.example;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

// In this program Update and Delete operations are present.
public class Main2 {
    public static void main(String[] args) {
        Student s1=new Student();
        SessionFactory sf=new Configuration()
                .addAnnotatedClass(org.example.Student.class)
                .configure()
                .buildSessionFactory();

        Session session=sf.openSession();
        Transaction transaction=session.beginTransaction();

        // Updating the data
        s1.setRollNo(2);
        s1.setsName("Mani");
        s1.setsAge(23);
        // Here changing the age from 21 o 23.
        // session.update(s1);
        // As update() is deprecated we use merge() which is similar to save() i.e.., if the data to be updated
        // is not available in the table it will directly insert it. For example :-
        //s1.setRollNo(4);
        //s1.setsName("Akhil");
        //s1.setsAge(22); // we don't have the data of 4 so merge() will inserts this data to table.

        session.merge(s1);
        System.out.println(s1);

        //Deleting the record for table
        //id should be given correct because it throws an exception if 'id' is not present.
        // if the id is present in the table, then only we should the 'id' otherwise it throws an error.
        Student s2=session.get(Student.class,3);
        // delete() method is deprecated we use remove() method.
        //session.delete(s2);
        session.remove(s2);

        transaction.commit();
        session.close();
        sf.close();
    }
}
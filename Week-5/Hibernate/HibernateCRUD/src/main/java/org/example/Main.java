package org.example;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student s1=new Student();
//        s1.setRollNo(1);
//        s1.setsName("Akash");
//        s1.setsAge(20);
        //This data is already inserted into table, so we get error if we again execute it.
        // So we create another record.

//        s1.setRollNo(2);
//        s1.setsName("Mani");
//        s1.setsAge(21);

        s1.setRollNo(3);
        s1.setsName("Anand");
        s1.setsAge(22);

//        Configuration cfg=new Configuration();
//        cfg.addAnnotatedClass(org.example.Student.class);
//        cfg.configure();
//
//        SessionFactory sf=cfg.buildSessionFactory();

        //The above four statements can also be written as:-
        SessionFactory sf=new Configuration()
                .addAnnotatedClass(org.example.Student.class)
                .configure()
                .buildSessionFactory();

        Session session=sf.openSession();

        Transaction transaction=session.beginTransaction();

        // Inserting data using save()
        // Since save() method is deprecated we another method called persist()
        //session.save(s1);
        //session.persist(s1);
        //System.out.println(s1);
        //After executing the record must be inserted into table in the database.


        //Fetching the data based on the primary key
        //Student s2=session.get(Student.class,2);
        //System.out.println(s2);
        //If we pass the id that is not available it prints the output as 'null'.

        //Fetching all records using CriteriaBuilder().
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = builder.createQuery(Student.class);
        criteriaQuery.from(Student.class);
        // Execute Query
        List<Student> students = session.createQuery(criteriaQuery).getResultList();
        for (Student st : students) {
            System.out.println(st.getRollNo() + " - " + st.getsName() + " - " + st.getsAge());
        }

        transaction.commit();
        // Close all resources because it can cause an exception. Ex:- switch off(close) the fan when you are not using it.
        session.close();
        sf.close();
    }
}
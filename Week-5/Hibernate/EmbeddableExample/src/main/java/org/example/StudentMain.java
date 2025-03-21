package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentMain {
    public static void main(String[] args){
        StudentAddress address=new StudentAddress();
        address.setHNo(37);
        address.setFlatNo(401);
        address.setLandmark("Hasmathpet");
        address.setPinCode(500009);

        Student student=new Student();
        student.setId(1);
        student.setName("Akash");
        student.setAge(20);
        student.setAddress(address);

        SessionFactory sf=new Configuration()
                .addAnnotatedClass(org.example.Student.class)
                .configure()
                .buildSessionFactory();
        Session session=sf.openSession();
        Transaction transaction=session.beginTransaction();

        session.persist(student);

        transaction.commit();
        session.close();
        sf.close();
    }
}


// Primary example of @Embeddable is that storing other information in a class by extending another class.
// For example, we have a class student , and we want to store address of student, so we create another
// class called address which has specific parameters such as house-no, flat-no, street, landmark, pin code.
// And this address class can be embedded in a student class using @Embeddable annotation in address class.
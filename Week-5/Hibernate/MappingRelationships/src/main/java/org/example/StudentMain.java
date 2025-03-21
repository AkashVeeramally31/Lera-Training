package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;


// @ManyToOne mapping is done here.

public class StudentMain {
    public static void main(String[] args){
        StudentAddress a1=new StudentAddress();
        a1.setHNo(37);
        a1.setFlatNo(401);
        a1.setLandmark("Hasmathpet");
        a1.setPinCode(500009);

        StudentAddress a2=new StudentAddress();
        a2.setHNo(41);
        a2.setFlatNo(402);
        a2.setLandmark("Suchitra");
        a2.setPinCode(507849);

        StudentAddress a3=new StudentAddress();
        a3.setHNo(40);
        a3.setFlatNo(502);
        a3.setLandmark("Miyapur");
        a3.setPinCode(500133);

        Student s1=new Student();
        s1.setId(1);
        s1.setName("Akash");
        s1.setAge(20);

        Student s2=new Student();
        s2.setId(2);
        s2.setName("Mani");
        s2.setAge(22);

        Student s3=new Student();
        s3.setId(3);
        s3.setName("Chiru");
        s3.setAge(25);

        s1.setAddress(Arrays.asList(a1,a2,a3));
        //If we have only one element we can replace it with List.of() method.
        //s2.setAddress(Arrays.asList(a2)); (OR)  s2.setAddress(List.of(a2));
        s2.setAddress(List.of(a2));
        s3.setAddress(Arrays.asList(a1,a3));

        a1.setStudents(Arrays.asList(s1,s3));
        a2.setStudents(Arrays.asList(s1,s2));
        a3.setStudents(Arrays.asList(s1,s3));

        SessionFactory sf=new Configuration()
                .addAnnotatedClass(org.example.Student.class)
                .addAnnotatedClass(org.example.StudentAddress.class)
                .configure()
                .buildSessionFactory();
        Session session=sf.openSession();
        Transaction transaction=session.beginTransaction();

        session.persist(a1);
        session.persist(a2);
        session.persist(a3);

        session.persist(s1);
        session.persist(s2);
        session.persist(s3);

        transaction.commit();

        // Fetching data
        Student st=session.get(Student.class,2);
        System.out.println(st.toString());

        session.close();
        sf.close();
    }
}

// Creates four tables:-
// 1) students_table:- Which involves only student details (id,name,age)
// 2) studentaddress:- which involves only address details (hno,flatno,landmark,pincode)
// 3) students_table_studentaddress :- which involves student_id and address_hno i.e.., (primary keys of
//                                                                                      both tables).
// 4) studentaddress_students_table:- which involves studentaddress_hno and student_id.

// If we want only three tables, then we use 'mappedBy' in any one of the class.
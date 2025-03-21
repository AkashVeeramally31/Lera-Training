package com.example.SpringDataJPA;

import com.example.SpringDataJPA.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {      //Can also use CrudRepository<>

    //If we do not any methods then we will create that methods using JPQL query language.
    //In this query language, table names can be written as class name and table columns are
    // replaced with class properties i.., attributes, using @Query annotation.
    @Query("select s from Student s where s.name=?1")
    List<Student> findByName(String name);
    // '?' is replaced with parameters that are passed in the method and '1' represents the count
    // of parameter i.e.., ?1 will take 1 parameter as input for the method.

    // @Query is optional for some case, not for all. Here the Jpa understands with th help of parameter name,
    // and it includes query at the backend. But if we include method as findBySMarks it doesn't allow
    // because the Jpa searches for SMarks int the table and it is not there so it throws an error.
    List<Student> findByMarks(int marks);

    List<Student> findByMarksGreaterThan(int marks);
}

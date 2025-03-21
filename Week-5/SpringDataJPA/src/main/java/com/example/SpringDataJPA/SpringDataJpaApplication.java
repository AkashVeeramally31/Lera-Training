package com.example.SpringDataJPA;

import com.example.SpringDataJPA.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {

		ApplicationContext context=SpringApplication.run(SpringDataJpaApplication.class, args);

		Student s1=context.getBean(Student.class);
		Student s2=context.getBean(Student.class);
		Student s3=context.getBean(Student.class);

		StudentRepo repo=context.getBean(StudentRepo.class);

		s1.setRollNo(1);
		s1.setName("Akash");
		s1.setMarks(98);

		s2.setRollNo(2);
		s2.setName("Mani");
		s2.setMarks(97);

		s3.setRollNo(3);
		s3.setName("Anand");
		s3.setMarks(99);

		//Inserting data using save().
		repo.save(s1);
		repo.save(s2);
		repo.save(s3);

		//Fetching data using findAll().
		System.out.println(repo.findAll());
		//Also
		//List<Student> ls=repo.findAll();
		//System.out.println(ls);

		//Fetching data by Id using findById().
		System.out.println(repo.findById(3).orElse(new Student()));

		//Gives null values because id:5 is not present.
		System.out.println(repo.findById(5).orElse(new Student()));

		//Fetching data by other attributes other than id.
		//repo.findByName("Akash");

		//Here we don't have findByName() method in JpaRepository so we create it in thr StudentRepo
		// using a query language known as JPQL(Java Persistence Query Language).

		//Now after creating a method we perform the operation.
		System.out.println(repo.findByName("Akash"));

		System.out.println(repo.findByMarks(98));

		System.out.println(repo.findByMarksGreaterThan(97));


		// Updating Data
		// Updating marks of s1:-
		s1.setMarks(100);
		repo.save(s1);

		//Deleting data
		repo.deleteById(3);
		// OR
		repo.delete(s3);
	}

}

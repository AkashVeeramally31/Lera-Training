package com.example.SpringJDBCDemo;

import com.example.SpringJDBCDemo.model.User;
import com.example.SpringJDBCDemo.repository.UserRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbcDemoApplication {

	public static void main(String[] args) {

		ApplicationContext con=SpringApplication.run(SpringJdbcDemoApplication.class, args);
		User us=con.getBean(User.class);
		us.setId(1);
		us.setName("Akash");
		us.setTech("Cyber security");

		UserRepo repo=con.getBean(UserRepo.class);
		repo.save(us);
		System.out.println(repo.findAll());
	}
}

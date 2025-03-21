package com.example.SpringSecurity_YT;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    List<Student> students=new ArrayList<>(List.of(
            new Student(1,"Akash",98),
            new Student(2,"Mani",99)
    ));

    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    // For method POST, PUT, DELETE, we need CSRF token.

    // If we want to create a new Student, we need CSRF token; CSRF token name is obtained from a view
    // page source of logout page, and value is obtained from getCsrfToken() which is implemented below
    // the PostMapping.
    // And after getting this, keep this name and value in the headers section of Postman as:
    // key: X-CSRF-TOKEN and value: (generated after running the below get-request)
    @PostMapping("/students")
    public String addStudent(@RequestBody Student student){
        students.add(student);
        return "Student added successfully";
    }

    @GetMapping("csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");   // '_csrf' is the token name obtained
                                                            // from a view page source of logout page.
    }
}

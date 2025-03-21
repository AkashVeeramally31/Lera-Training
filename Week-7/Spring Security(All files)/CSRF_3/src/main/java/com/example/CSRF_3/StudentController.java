package com.example.CSRF_3;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    List<Student> students=new ArrayList<>(List.of(
            new Student(1,"Akash",20),
            new Student(2,"Mani",21)
    ));

    @GetMapping("students")
    public List<Student> getStudents(){
        return students;
    }

    @PostMapping("students")
    public String addStudent(@RequestBody Student student){
        students.add(student);
        return "Student added successfully";
    }
    // Here PostMapping doesn't work because we don't have CSRF token.
    // So we create a method to get CSRF token, and with the help of that token we send
    // the request using PostMapping.
    @GetMapping("csrf-token")
    public CsrfToken getToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
    // '_csrf' is a token name that we will get from 'view page source' of logout page(right-click).
    // In that page, copy the 'input name' field

    // After this, go to postman give the url: - http://localhost:8080/csrf-token
    // this will give the Csrf-token.
    // Copy that token and headerName and keep it in headers.
    // Keep headerName in key and csrf-token in value and then send the PostMapping request, you will
    // get the output.

    @DeleteMapping("/students/{id}")
    public String delete(@PathVariable int id){
        students.remove(id);    //Uses 0-based indexing.
        return "Student with id:"+(id+1)+" deleted successfully";
    }
}

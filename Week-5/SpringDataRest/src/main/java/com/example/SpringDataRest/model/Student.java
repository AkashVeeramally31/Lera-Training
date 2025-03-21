package com.example.SpringDataRest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    private int id;
    private String name;
    private int age;
}

// Automatically the url will be table (or) class name followed by 's'(plural) i.e.., table (or) class
// name is student then url will be:- (GET) http://localhost:8080/students

// To fetch single student then url will be:- (GET) http://localhost:8080/students/{id}

// To add student then url will be:- (POST) http://localhost:8080/students  and add details in the body.

// To update the existing student then url:- (PUT) http://localhost:8080/students/{id} and add new
// details in the body.

// To delete student url:- (DELETE) http://localhost:8080/students/{id}


package com.example.SpringDataRest.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class JobPost {

    @Id
    private int postId;
    private String postProfile;
    private String postDesc;
    private Integer reqExperience;
    private List<String> postTechStack;
}

// Automatically the url will be table (or) class name followed by 's'(plural) i.e.., if table (or) class
// name is jobPost then url will be:- (GET) http://localhost:8080/jobPosts

// To fetch single jobPost then url will be:- (GET) http://localhost:8080/jobPosts/{id}

// To add jobPost url will be:- (POST) http://localhost:8080/jobPosts and add details in the body.

// To update the existing jobPost then url:- (PUT) http://localhost:8080/jobPosts/{id} and add new
// details in the body.

// To delete jobPost then url: (DELETE) http://localhost:8080/jobPosts/{id}
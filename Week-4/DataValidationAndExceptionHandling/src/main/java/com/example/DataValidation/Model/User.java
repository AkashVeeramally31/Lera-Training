package com.example.DataValidation.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Users")
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String mobile;
    private String gender;
    private int age;
    private String nationality;
}

//Sometimes passing invalid data becomes hectic for the server to share the information.
//For example, if we give mobile number as "0809" but it should be a 10-digit number, also for other attributes there are
// particular rules to meet their requirements.

//So, in this case Data Validation concept is very important. For this we will create a DTO class which is UserRequest
//in which we perform all the necessary validations using in-built annotations.

// DTO:- Data Transfer Object:- A data transfer object (DTO) is an object that carries data between processes.
// You can use this technique to facilitate communication between two systems (like an API and your server)
// without potentially exposing sensitive information.
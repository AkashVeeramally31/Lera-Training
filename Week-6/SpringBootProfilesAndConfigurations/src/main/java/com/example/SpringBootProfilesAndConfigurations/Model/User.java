package com.example.SpringBootProfilesAndConfigurations.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users_table")
public class User {
    @Id
    private int id;
    private String name;
    private int age;
}

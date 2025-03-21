package org.example;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "students_table") //Giving table name because database already consist of table named student.
public class Student {
    @Id
    private int id;
    private String name;
    private int age;

    @ManyToMany
    private List<StudentAddress> address;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<StudentAddress> getAddress() {
        return address;
    }

    public void setAddress(List<StudentAddress> address) {
        this.address = address;
    }

    //To fetch the data toString() method is mandatory otherwise it will return some address value.
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}

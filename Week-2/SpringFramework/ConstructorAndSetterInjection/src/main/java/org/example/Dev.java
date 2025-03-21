package org.example;

import org.springframework.beans.factory.annotation.Autowired;

public class Dev {
    private int age;

    public Dev(int age) {
        this.age = age;
        System.out.println("Dev Parameterized constructor");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Dev(){
        System.out.println("Dev Constructor..");
    }

    public void compile(){
        System.out.println("Working on Awesome Project..");
    }
}

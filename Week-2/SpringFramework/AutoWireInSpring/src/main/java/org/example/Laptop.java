package org.example;

public class Laptop implements Computer {
    Laptop(){
        System.out.println("Laptop Constructor");
    }
    public void compile() {
        System.out.println("Compiling in Laptop");
    }
}

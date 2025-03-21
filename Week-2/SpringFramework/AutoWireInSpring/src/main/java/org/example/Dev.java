package org.example;

public class Dev {
    private Computer comp;
    public Computer getComp() {
        return comp;
    }

    public void setComp(Computer comp) {
        this.comp = comp;
    }

    Dev(){
        System.out.println("Dev Constructor");
    }
    public void display(){
        System.out.println("Working on Awesome Project.");
        comp.compile();
    }
}

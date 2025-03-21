package org.example;

public class DevObj {
    private LaptopObj lap;

    public DevObj(LaptopObj lap) {
        this.lap = lap;
        System.out.println("DevObj Parameterized Constructor");
    }

    public LaptopObj getLap() {
        return lap;
    }

    public void setLap(LaptopObj lap) {
        this.lap = lap;
    }

    public DevObj(){
        System.out.println("DevObj Constructor");
    }
    public void compile(){
        System.out.println("Working on Awesome Project..");
        lap.display();
    }
}

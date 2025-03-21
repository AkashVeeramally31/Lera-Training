package org.example;

import jakarta.persistence.Embeddable;

//The @Embeddable annotation in Hibernate is used to embed one class inside another without treating
// it as a separate entity. This is useful when you have a value-type class (like an address) that
// should be part of another entity (like an employee).

@Embeddable
public class Laptop {
    private int ram;
    private String brand;
    private String model;

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    //To fetch the data toString() method is mandatory otherwise it will return some address value.
    @Override
    public String toString() {
        return "Laptop{" +
                "ram=" + ram +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}

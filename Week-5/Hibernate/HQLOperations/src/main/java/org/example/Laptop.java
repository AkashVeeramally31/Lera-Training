package org.example;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Cacheable
public class Laptop {

    @Id
    private int lid;
    private int ram;
    private String brand;
    private String model;

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

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
                "lid=" + lid +
                ", ram=" + ram +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}

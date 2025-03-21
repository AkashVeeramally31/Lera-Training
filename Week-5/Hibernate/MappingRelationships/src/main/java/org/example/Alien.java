package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.List;

@Entity
public class Alien {
    @Id
    private int aid;
    private String aname;
    private String tech;

    // Mapping @OneToOne involves storing the lid of Laptop as foreign key in the alien table.
    // @OneToOne
    // private Laptop laptop;

    // In some case, if an alien has multiple laptops then we use @OneToMany relationship.So for this we use List.
    // And it creates a new table with common name of both tables, here 'alien_laptop' will be created. In
    // that table it consists of aid and lid corresponding to their particular laptops and aliens.
    // @OneToMany
    // private List<Laptop> laptops;

    // If we don't want the third table we use @ManyToOne mapping for the Alien class in the Laptop class.
    // For this we need to create reference of Alien in the Laptop class and need to use @ManyToOne annotation.
    // And we need to tell Alien to not create the extra table by specifying mappedBy=(Alien Reference object name).
    // Here reference name is 'alien' in the Laptop class i.e.., given as @OneToMany(mappedBy="alien")
    @OneToMany(mappedBy = "alien")
    private List<Laptop> laptops;


    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

//    public Laptop getLaptop() {
//        return laptop;
//    }
//
//    public void setLaptop(Laptop laptop) {
//        this.laptop = laptop;
//    }

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", tech='" + tech + '\'' +
                ", laptop=" + laptops +
                '}';
    }
}

package org.example;

import jakarta.persistence.*;

@Entity
//We can change the table name using @Table i.e..,. by default table name will be class name.
@Table(name = "alien_table")
public class Alien {
    @Id
    private int aid;

    //We can also change the column name using @Column i.e..,. by default column name will be attribute name.
    @Column(name = "alien_name")
    private String aname;

    @Transient
    private String tech;    //Will not be stored in the database.

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

    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", tech='" + tech + '\'' +
                '}';
    }
}

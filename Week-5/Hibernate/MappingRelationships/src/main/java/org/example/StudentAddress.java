package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.List;

@Entity
public class StudentAddress {
    @Id
    private int HNo;
    private int flatNo;
    private String landmark;
    private int pinCode;

    // 'mappedBy' is used to avoid creation of extra table using reference of another class. In this case, address is
    // the reference.
    // @ManyToMany (creates four tables) (OR) @ManyToMany(mappedBy = "address") (creates only three tables).
    @ManyToMany(mappedBy = "address")
    private List<Student> students;

    public int getHNo() {
        return HNo;
    }

    public void setHNo(int HNo) {
        this.HNo = HNo;
    }

    public int getFlatNo() {
        return flatNo;
    }

    public void setFlatNo(int flatNo) {
        this.flatNo = flatNo;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    //To fetch the data toString() method is mandatory otherwise it will return some address value.
    @Override
    public String toString() {
        return "StudentAddress{" +
                "HNo=" + HNo +
                ", flatNo=" + flatNo +
                ", landmark='" + landmark + '\'' +
                ", pinCode=" + pinCode +
                '}';
    }
}

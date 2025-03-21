package org.example;

import jakarta.persistence.Embeddable;

//The @Embeddable annotation in Hibernate is used to embed one class inside another without treating
// it as a separate entity. This is useful when you have a value-type class (like an address) that
// should be part of another entity (like an employee).

@Embeddable
public class StudentAddress {
    private int HNo;
    private int flatNo;
    private String landmark;
    private int pinCode;

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

package com.example.SpringActuator;


import org.springframework.stereotype.Component;

@Component
public class UserEntity {
    String id = "1";
    String name = "Darshan.G.Pawar";
    String userName = "@drash";
    String email = "drash@geek";
    String pincode = "422-009";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
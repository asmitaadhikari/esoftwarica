package com.example.esoftwarica.Model;

import java.util.ArrayList;
import java.util.List;

public class Students {

    private String name, address, gender ;
    private int image,age;

    public Students(String name, String address, String gender, int age, int imgId) {
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.age = age;
        this.image = imgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

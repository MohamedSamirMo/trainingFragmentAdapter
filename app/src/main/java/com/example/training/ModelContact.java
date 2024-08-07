package com.example.training;

public class ModelContact {
    private String name;
    private String phone;

    public ModelContact(String name,String phone){
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}

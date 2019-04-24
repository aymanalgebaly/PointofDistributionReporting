package com.compubase.podra.data.model;


public class ViewPersonnelModel {

    private String num,name,location,phone;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public ViewPersonnelModel() {
    }

    public ViewPersonnelModel(String name, String location, String phone, String num) {
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

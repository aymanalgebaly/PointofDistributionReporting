package com.compubase.podra.data.model;

public class PodModifyModel {

    private String num,name,status;

    public PodModifyModel() {
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PodModifyModel(String num, String name, String status) {
        this.num = num;
        this.name = name;
        this.status = status;
    }
}

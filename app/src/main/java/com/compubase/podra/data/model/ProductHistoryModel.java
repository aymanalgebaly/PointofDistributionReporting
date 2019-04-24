package com.compubase.podra.data.model;

public class ProductHistoryModel {
    private String num,name,start,end;

    public ProductHistoryModel() {
    }

    public ProductHistoryModel(String num, String name, String start, String end) {
        this.num = num;
        this.name = name;
        this.start = start;
        this.end = end;
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

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}

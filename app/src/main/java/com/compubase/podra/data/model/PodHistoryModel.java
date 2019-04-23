package com.compubase.podra.data.model;

import android.widget.TextView;

public class PodHistoryModel {

    private String name,num,startDate,EndDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }

    public PodHistoryModel(String name, String num, String startDate, String endDate) {
        this.name = name;
        this.num = num;
        this.startDate = startDate;
        EndDate = endDate;
    }

    public PodHistoryModel() {
    }
}

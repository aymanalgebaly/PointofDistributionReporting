package com.compubase.podra.data.model;

public class FristPersonnelModel {

    private String discribtion;

    public FristPersonnelModel() {
    }

    public FristPersonnelModel(String discribtion, int img) {
        this.discribtion = discribtion;
        this.img = img;
    }

    public String getDiscribtion() {
        return discribtion;
    }

    public void setDiscribtion(String discribtion) {
        this.discribtion = discribtion;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    private int img;
}

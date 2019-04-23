package com.compubase.podra.data.model;

import android.widget.Button;

public class ActiveProductModel {
    private String num,product_name,quantity;

    public ActiveProductModel(String num, String product_name, String quantity) {
        this.num = num;
        this.product_name = product_name;
        this.quantity = quantity;
    }

    public ActiveProductModel() {
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}

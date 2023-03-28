package com.velov.shoeshop.entities;

import java.io.Serializable;

public class SizeJson implements Serializable {

    private int size;

    private int quantity;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

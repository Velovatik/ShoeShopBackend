package com.velov.shoeshop.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "sizes")
public class Size {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "Size")
    private int size;

    @Column(name = "Quantity")
    private int quantity;

    @Column(name = "goodId")
    private int goodId;

    public Size() {

    }

    public Size(int size, int quantity, int goodId) {
        this.size = size;
        this.quantity = quantity;
        this.goodId = goodId;
    }

    public int getId() {
        return Id;
    }

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

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }
}

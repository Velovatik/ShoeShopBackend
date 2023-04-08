package com.velov.shoeshop.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "manufacturers")
public class Manufacturer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ManufacturerName")
    private String manufacturerName;

    @Column(name = "Address")
    private String address;

    @Column(name = "Telephone")
    private String telephone;

    //@JsonBackReference
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH,
            CascadeType.REFRESH, CascadeType.MERGE},
            mappedBy = "manufacturer")
    @JsonIgnore
    private List<Good> goods;

    public Manufacturer() {

    }

    public Manufacturer(String manufacturerName, String address, String telephone) {
        this.manufacturerName = manufacturerName;
        this.address = address;
        this.telephone = telephone;
    }

    public void addGoodToManufacturer(Good good) {
        if (goods == null) {
            goods = new ArrayList<>();
        }
        goods.add(good);
        good.setManufacturer(this);
    }

    public List<Good> getGoods() {
        return goods;
    }

    public void setGoods(List<Good> goods) {
        this.goods = goods;
    }

    public int getId() {
        return id;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Manufacturers{" +
                "Id=" + id +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}

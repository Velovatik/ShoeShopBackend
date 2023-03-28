package com.velov.shoeshop.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "manufacturers")
public class Manufacturers {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "ManufacturerName")
    private String manufacturerName;

    @Column(name = "Address")
    private String address;

    @Column(name = "Telephone")
    private String telephone;

    public Manufacturers() {

    }

    public Manufacturers(String manufacturerName, String address, String telephone) {
        this.manufacturerName = manufacturerName;
        this.address = address;
        this.telephone = telephone;
    }

    public int getId() {
        return Id;
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
                "Id=" + Id +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}

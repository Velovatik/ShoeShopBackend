package com.velov.shoeshop.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name = "goods")
public class Good {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String title;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "size")
    private SizeJson sizeJson;

    @Enumerated(EnumType.STRING)
    @Column(name = "sex")
    private sexType sexType;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH,
    CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "Manufacturerid")
    Manufacturer manufacturer; //Many goods can` refer to one manufacturer

    public Good() {

    }

    public Good(String title, SizeJson sizeJson, com.velov.shoeshop.entities.sexType sexType, Manufacturer manufacturer) {
        this.title = title;
        this.sizeJson = sizeJson;
        this.sexType = sexType;
        this.manufacturer = manufacturer;
    }

    public int getId() {
        return Id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public SizeJson getSizeJson() {
        return sizeJson;
    }

    public void setSizeJson(SizeJson sizeJson) {
        this.sizeJson = sizeJson;
    }

    public com.velov.shoeshop.entities.sexType getSexType() {
        return sexType;
    }

    public void setSexType(com.velov.shoeshop.entities.sexType sexType) {
        this.sexType = sexType;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "Id=" + Id +
                ", title='" + title + '\'' +
                ", sizeJson=" + sizeJson +
                ", sexType=" + sexType +
                ", manufacturer=" + manufacturer +
                '}';
    }
}

package com.velov.shoeshop.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "goods")
public class Good {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "Title")
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "sex")
    private sexType sexType;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH,
    CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "ManufacturerId")
    Manufacturer manufacturer; //Many goods can refer to one manufacturer

    @OneToMany(cascade = CascadeType.ALL) //Uni-directional reference to size array
    @JoinColumn(name = "goodId")
    List<Size> sizes;

    public void addSizeToGood(Size size) {
        if (sizes == null) sizes = new ArrayList<>();
        sizes.add(size);
        
    }

    public Good() {

    }

    public Good(String title, com.velov.shoeshop.entities.sexType sexType, Manufacturer manufacturer) {
        this.title = title;
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
                ", sexType=" + sexType +
                ", manufacturer=" + manufacturer +
                '}';
    }
}

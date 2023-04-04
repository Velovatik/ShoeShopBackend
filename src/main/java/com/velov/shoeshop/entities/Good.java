package com.velov.shoeshop.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "goods")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Good {
    @Id
    @Column(name = "id")
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
    @JsonManagedReference //-------------------------------------------------------
    Manufacturer manufacturer; //Many goods can refer to one manufacturer

    @JsonBackReference
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH,
            CascadeType.REFRESH, CascadeType.MERGE}, mappedBy = "good")  //Uni-directional reference to size array
            //@JoinColumn(name= "goodid")
    List<Size> sizes; //Refactor to bi-directional relationship

    public void addSizeToGood(Size size) {
        if (sizes == null) sizes = new ArrayList<>();
        sizes.add(size);
        //size.setGood(this);
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

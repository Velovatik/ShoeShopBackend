package com.velov.shoeshop.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "goods")
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id")
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

    /**
     * proved and it actually works!
     */
    @JsonManagedReference
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH,
    CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "ManufacturerId")
    Manufacturer manufacturer; //Many goods can refer to one manufacturer


    @JsonManagedReference
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH,
            CascadeType.REFRESH, CascadeType.MERGE}, mappedBy = "good")//Uni-directional reference to size array
    List<Size> sizes;

    public void addSizeToGood(Size size) {
        if (sizes == null) sizes = new ArrayList<>();
        sizes.add(size);
        size.setGood(this);
    }

    //Constructors
    public Good() {

    }

    public Good(String title, com.velov.shoeshop.entities.sexType sexType, Manufacturer manufacturer) {
        this.title = title;
        this.sexType = sexType;
        this.manufacturer = manufacturer;
    }

    //Getters and setters
    public int getId() {
        return Id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public sexType getSexType() {
        return sexType;
    }

    public void setSexType(sexType sexType) {
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

package com.velov.shoeshop.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "goods")
public class Good {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@JsonIgnore
    private int id;

    @Column(name = "Title")
    private String title;

//    @Enumerated(EnumType.STRING)
//    @Column(name = "sex")
//    private sexType sexType;

    @Column(name = "sex")
    private String sex;

    /**
     * proved and it actually works!
     */
    //@JsonManagedReference
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH,
    CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "ManufacturerId")
    //@JsonIgnoreProperties
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
        //this.sexType = sexType;
        this.manufacturer = manufacturer;
        this.sex = sex;
    }

    //Getters and setters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public sexType getSexType() {
//        return sexType;
//    }


//    public void setSexType(sexType sexType) {
//        this.sexType = sexType;
//    }


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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
                "Id=" + id +
                ", title='" + title + '\'' +
//                ", sexType=" + sexType +
                ", manufacturer=" + manufacturer +
                '}';
    }
}

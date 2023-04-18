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
    @JoinColumn(name = "ManufacturerId", insertable = false, updatable = false)
    Manufacturer manufacturer; //Many goods can refer to one manufacturer

    @Column(name = "manufacturerId")
    private int manufacturerId;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "good")//Uni-directional reference to size array
    List<Size> sizes; //Change CascadeType in case delete size cause deletion of Good (in future)

    public void addSizeToGood(Size size) {
        if (sizes == null) sizes = new ArrayList<>();
        sizes.add(size);
        size.setGood(this);
    }

    //Constructors
    public Good() {

    }

    public Good(String title, String sex, Manufacturer manufacturer, List<Size> sizes) {
        this.title = title;
        this.sex = sex;
        this.manufacturer = manufacturer;
        this.sizes = sizes;
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

    public List<Size> getSizes() {
        return sizes;
    }

    public void setSizes(List<Size> sizes) {
        this.sizes = sizes;
    }

    public int getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(int manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "Id=" + id +
                ", title='" + title + '\'' +
                "sex=" + sex +
//                ", sexType=" + sexType +
                ", manufacturer=" + manufacturer +
                '}';
    }
}

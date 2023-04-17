package com.velov.shoeshop.dto;

import com.velov.shoeshop.entities.Manufacturer;
import com.velov.shoeshop.entities.Size;

import java.util.List;

public class GoodDTO {
    private int id;

    private String title;

    private String sex;

    private Manufacturer manufacturer; //needs Id only

    List<Integer> sizes;

    //Constructor

    public GoodDTO(String title, String sex, Manufacturer manufacturer, List<Size> sizes) {
        this.title = title;
        this.sex = sex;
        this.manufacturer = manufacturer;
        //this.sizes = sizes;
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

}

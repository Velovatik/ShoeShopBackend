package com.velov.shoeshop.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.velov.shoeshop.entities.Size;

import java.util.List;

public class GoodPostDTO {
    @JsonProperty("id")
    private int id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("sex")
    private String sex;

    @JsonProperty("manufacturer")//Maybe need to change name to manufacturerId
    private int manufacturer; //Require Id only

    @JsonProperty("sizes")
    private List<Size> sizes;

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

    public int getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(int manufacturer) {
        this.manufacturer = manufacturer;
    }

    public List<Size> getSizes() {
        return sizes;
    }

    public void setSizes(List<Size> sizes) {
        this.sizes = sizes;
    }
}

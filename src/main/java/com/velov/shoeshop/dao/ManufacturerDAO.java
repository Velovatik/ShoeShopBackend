package com.velov.shoeshop.dao;

import com.velov.shoeshop.entities.Manufacturer;

import java.util.List;

public interface ManufacturerDAO {
    public List<Manufacturer> getAllManufacturers();

    public Manufacturer getManufacturer(int id);

    public void saveManufacturer(Manufacturer manufacturer);

    public void deleteManufacturer(int id);
}

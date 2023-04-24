package com.velov.shoeshop.service;

import com.velov.shoeshop.entities.Good;
import com.velov.shoeshop.entities.Manufacturer;

import java.util.List;

public interface ManufacturerService {
    public List<Manufacturer> getAllManufacturers();

    public Manufacturer getManufacturer(int id);

    public void saveManufacturer(Manufacturer manufacturer);

    public void deleteManufacturer(int id);
}

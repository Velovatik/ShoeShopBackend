package com.velov.shoeshop.service;

import com.velov.shoeshop.dao.GoodDAO;
import com.velov.shoeshop.dao.ManufacturerDAO;
import com.velov.shoeshop.entities.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService{
    @Autowired
    private ManufacturerDAO manufacturerDAO;

    @Override
    @Transactional
    public List<Manufacturer> getAllManufacturers() {
        return manufacturerDAO.getAllManufacturers();
    }

    @Override
    public Manufacturer getManufacturer(int id) {
        return manufacturerDAO.getManufacturer(id);
    }

    @Override
    @Transactional
    public void saveManufacturer(Manufacturer manufacturer) {

        manufacturerDAO.saveManufacturer(manufacturer);
    }

    @Override
    @Transactional
    public void deleteManufacturer(int id) {
        manufacturerDAO.deleteManufacturer(id);
    }
}

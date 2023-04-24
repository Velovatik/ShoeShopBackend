package com.velov.shoeshop.dao;

import com.velov.shoeshop.entities.Good;
import com.velov.shoeshop.entities.Manufacturer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ManufacturerDAOImpl implements ManufacturerDAO {

    @Autowired
    private EntityManager entityManager;


    @Override
    @Transactional
    public List<Manufacturer> getAllManufacturers() {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("from Manufacturer", Manufacturer.class);
        List<Manufacturer> manufacturers = query.getResultList();

        return manufacturers;
    }

    @Override
    public Manufacturer getManufacturer(int id) {
        Session session = entityManager.unwrap(Session.class);

        Manufacturer manufacturer = session.get(Manufacturer.class, id);

        return manufacturer;
    }

    @Override
    public void saveManufacturer(Manufacturer manufacturer) {
        Session session = entityManager.unwrap(Session.class);

        session.merge(manufacturer);
    }

    @Override
    @Transactional
    public void deleteManufacturer(int id) {
        Session session = entityManager.unwrap(Session.class);

        Query query = session.createQuery("delete from Manufacturer where id =: manufacturerId");
        query.setParameter("manufacturerId", id);
        query.executeUpdate();
    }
}

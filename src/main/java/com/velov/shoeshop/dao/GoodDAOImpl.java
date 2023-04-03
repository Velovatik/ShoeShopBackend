package com.velov.shoeshop.dao;

import com.velov.shoeshop.entities.Good;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class GoodDAOImpl implements GoodDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional //Spring open and close transactions automatically
    public List<Good> getAllGoods() {
        Session session = entityManager.unwrap(Session.class);
        List<Good> allGoods = session.createQuery("from Good", Good.class).getResultList(); //Refactor to best practice

        return allGoods;
    }
}

package com.velov.shoeshop.dao;

import com.velov.shoeshop.entities.Good;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class GoodDAOImpl implements GoodDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional //Spring open and close transactions automatically
    public List<Good> getAllGoods() {
        Session session = sessionFactory.getCurrentSession();
        List<Good> allGoods = session.createQuery("from Good", Good.class).getResultList();

        return allGoods;
    }
}

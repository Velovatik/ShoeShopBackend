package com.velov.shoeshop.dao;

import com.velov.shoeshop.entities.Good;
import com.velov.shoeshop.entities.Size;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
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

        Query<Good> query = session.createQuery("from Good", Good.class);
//        Query<Good> query =
        List<Good> allGoods = query.getResultList();

        return allGoods;
    }
}

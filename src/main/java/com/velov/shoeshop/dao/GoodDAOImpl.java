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

        List<Good> allGoods = query.getResultList();

        return allGoods;
    }

    @Override
    public void saveGood(Good good) {
        Session session = entityManager.unwrap(Session.class);

        session.merge(good); //SaveOrUpdate substitute
    }


    @Override
    @Transactional
    public void deleteGood(int id) {
        Session session = entityManager.unwrap(Session.class);

        Query query = session.createQuery("delete from Good " +
                "where id =: goodid");
        query.setParameter("goodid", id);
        query.executeUpdate();
    }
}

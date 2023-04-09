package com.velov.shoeshop.service;

import com.velov.shoeshop.dao.GoodDAO;
import com.velov.shoeshop.entities.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GoodServiceImpl implements GoodService{

    @Autowired
    private GoodDAO goodDAO;

    @Override
    @Transactional
    public List<Good> getAllGoods() {
        return goodDAO.getAllGoods();
    }

    @Override
    @Transactional
    public void saveGood(Good good) {

        goodDAO.saveGood(good);
    }

    @Override
    @Transactional
    public void deleteGood(int id)  {
        goodDAO.deleteGood(id);
    }
}

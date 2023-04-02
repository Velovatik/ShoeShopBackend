package com.velov.shoeshop.service;

import com.velov.shoeshop.dao.GoodDAO;
import com.velov.shoeshop.entities.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodServiceImpl implements GoodService{

    @Autowired
    private GoodDAO goodDAO;

    @Override
    public List<Good> getAllGoods() {
        return goodDAO.getAllGoods();
    }
}

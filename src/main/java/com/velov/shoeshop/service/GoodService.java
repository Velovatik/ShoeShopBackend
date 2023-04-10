package com.velov.shoeshop.service;

import com.velov.shoeshop.entities.Good;

import java.util.List;

public interface GoodService {
    public List<Good> getAllGoods();

    public void saveGood(Good good);

    public void deleteGood(int id);

    public void sellGood(int id, int size, int amount);
}

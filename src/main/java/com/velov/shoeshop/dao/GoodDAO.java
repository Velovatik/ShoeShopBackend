package com.velov.shoeshop.dao;

import com.velov.shoeshop.entities.Good;

import java.util.List;

public interface GoodDAO {
    public List<Good> getAllGoods();

    public Good getGood(int id);

    public void saveGood(Good good);

    public void deleteGood(int id);

    public void sellGood(int id, int size, int amount);
}

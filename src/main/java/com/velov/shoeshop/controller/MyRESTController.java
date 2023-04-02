package com.velov.shoeshop.controller;

import com.velov.shoeshop.entities.Good;
import com.velov.shoeshop.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private GoodService goodService;

    @GetMapping("/goods")
    public List<Good> showAllGoods() {
        List<Good> allGoods = goodService.getAllGoods();
        return allGoods;
    }
}

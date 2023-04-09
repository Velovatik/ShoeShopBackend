package com.velov.shoeshop.controller;

import com.velov.shoeshop.entities.Good;
import com.velov.shoeshop.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/goods")
    public Good addNewGood(@RequestBody Good good) {
        goodService.saveGood(good);
        return good;
    }

    @PutMapping("/goods")
    public Good updateGood(@RequestBody Good good) {
        goodService.saveGood(good);
        return good;
    }

    @DeleteMapping("/goods/{id}")
    public String deleteGood(@PathVariable int id) {
        goodService.deleteGood(id);
        return "Good with id = " + id + " deleted";
    }
}

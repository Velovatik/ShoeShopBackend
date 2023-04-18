package com.velov.shoeshop.controller;

import com.velov.shoeshop.entities.Good;
import com.velov.shoeshop.entities.Manufacturer;
import com.velov.shoeshop.service.GoodService;
import com.velov.shoeshop.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:5173/")
public class MyRESTController {

    @Autowired
    private GoodService goodService;

    @Autowired
    private ManufacturerService manufacturerService;

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

    @GetMapping("goods/{id}")
    public Good getGood(@PathVariable int id) {
        Good good = goodService.getGood(id);

        return good;
    }

    @DeleteMapping("/goods/{id}")
    public String deleteGood(@PathVariable int id) {
        goodService.deleteGood(id);
        return "Good with id = " + id + " was deleted";
    }

    @PutMapping("/purchase/{id}/{size}/{amount}")
    public String sellGood(@PathVariable int id, @PathVariable int size, @PathVariable int amount) {
        goodService.sellGood(id, size, amount);
        return "Sold " + amount + " pair(s) of shoes size " + size + " with id = " + id;
    }

    @GetMapping("/manufacturers")
    public List<Manufacturer> showAllManufacturers() {
        List<Manufacturer> allManufacturers = manufacturerService.getAllManufacturers();

        return allManufacturers;
    }

    @PostMapping("/manufacturers")
    public Manufacturer addNewManufacturer(@RequestBody Manufacturer manufacturer) {
        manufacturerService.saveManufacturer(manufacturer);
        return manufacturer;
    }

    @PutMapping("/manufacturers")
    public Manufacturer updateManufacturer(@RequestBody Manufacturer manufacturer) {
        manufacturerService.saveManufacturer(manufacturer);
        return manufacturer;
    }

    @DeleteMapping("/manufacturers/{id}")
    public String deleteManufacturer(@PathVariable int id) {
        manufacturerService.deleteManufacturer(id);
        return "Manufacturer with id = " + id + " was deleted";
    }
}

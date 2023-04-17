package com.velov.shoeshop.dto;

import com.velov.shoeshop.entities.Good;
import com.velov.shoeshop.entities.Manufacturer;
import com.velov.shoeshop.entities.Size;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class Mapper {
    public GoodDTO toDto(Good good) {
        String title = good.getTitle();
        Manufacturer manufacturer = good.getManufacturer();
        String sex = good.getSex();
        List<Integer> sizes = good
                .getSizes()
                .stream()
                .map(Size::getSize)
                .collect(toList());

        return new GoodDTO(title, sex, manufacturer, sizes);
    }
}

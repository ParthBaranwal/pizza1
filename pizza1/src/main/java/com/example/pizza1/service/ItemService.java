package com.example.pizza1.service;

import com.example.pizza1.dto.ItemDTO;
import com.example.pizza1.entity.Beverage;
import com.example.pizza1.entity.Pizza;
import com.example.pizza1.entity.Sides;
import com.example.pizza1.entity.Topping;
import com.example.pizza1.repository.BeverageRepository;
import com.example.pizza1.repository.PizzaRepository;
import com.example.pizza1.repository.SidesRepository;
import com.example.pizza1.repository.ToppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private ToppingRepository toppingRepository;

    @Autowired
    private SidesRepository sidesRepository;

    @Autowired
    private BeverageRepository beverageRepository;

    public ItemDTO getAllItems() {
        ItemDTO itemDTO = new ItemDTO();

        itemDTO.setPizzas(pizzaRepository.findAll());
        itemDTO.setToppings(toppingRepository.findAll());
        itemDTO.setSides(sidesRepository.findAll());
        itemDTO.setBeverages(beverageRepository.findAll());

        return itemDTO;
    }
}

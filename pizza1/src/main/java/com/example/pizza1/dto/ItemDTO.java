package com.example.pizza1.dto;

import com.example.pizza1.entity.Beverage;
import com.example.pizza1.entity.Pizza;
import com.example.pizza1.entity.Sides;
import com.example.pizza1.entity.Topping;

import java.util.List;

public class ItemDTO {
    private List<Pizza> pizzas;
    private List<Topping> toppings;
    private List<Sides> sides;
    private List<Beverage> beverages;

    // Getters and Setters

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    public List<Sides> getSides() {
        return sides;
    }

    public void setSides(List<Sides> sides) {
        this.sides = sides;
    }

    public List<Beverage> getBeverages() {
        return beverages;
    }

    public void setBeverages(List<Beverage> beverages) {
        this.beverages = beverages;
    }
}

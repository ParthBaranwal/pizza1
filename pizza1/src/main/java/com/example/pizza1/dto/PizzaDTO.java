package com.example.pizza1.dto;

import com.example.pizza1.entity.Pizza;
import java.math.BigDecimal;

public class PizzaDTO {

    private Long id;
    private String pizzaName;
    private String description;
    private BigDecimal pizzaPrice;

    // Constructors
    public PizzaDTO() {}

    public PizzaDTO(Long id, String pizzaName, String description, BigDecimal pizzaPrice) {
        this.id = id;
        this.pizzaName = pizzaName;
        this.description = description;
        this.pizzaPrice = pizzaPrice;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPizzaPrice() {
        return pizzaPrice;
    }

    public void setPizzaPrice(BigDecimal pizzaPrice) {
        this.pizzaPrice = pizzaPrice;
    }

    // Convert from Pizza entity to PizzaDTO
    public static PizzaDTO fromEntity(Pizza pizza) {
        return new PizzaDTO(
                pizza.getP_id(),
                pizza.getPizza_name(),
                pizza.getDescription(),
                pizza.getPizza_price()
        );
    }
}

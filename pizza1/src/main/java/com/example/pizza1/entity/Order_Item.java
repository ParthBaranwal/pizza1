package com.example.pizza1.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "or_item")
public class Order_Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oi_id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "pizza_id", nullable = false)
    private Pizza pizza;

    @ManyToOne
    @JoinColumn(name = "sides_id")
    private Sides sides;

    @ManyToOne
    @JoinColumn(name = "beverage_id")
    private Beverage beverage;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToMany
    @JoinTable(
            name = "order_item_topping",
            joinColumns = @JoinColumn(name = "order_item_id"),
            inverseJoinColumns = @JoinColumn(name = "topping_id")
    )
    private Set<Topping> toppings;

    private int pizzaQuantity; // New field for Pizza quantity
    private int sidesQuantity; // New field for Sides quantity
    private int beverageQuantity; // New field for Beverage quantity

    private BigDecimal oi_price;

    // Getters and setters

    public Long getOi_id() {
        return oi_id;
    }

    public void setOi_id(Long oi_id) {
        this.oi_id = oi_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Sides getSides() {
        return sides;
    }

    public void setSides(Sides sides) {
        this.sides = sides;
    }

    public Beverage getBeverage() {
        return beverage;
    }

    public void setBeverage(Beverage beverage) {
        this.beverage = beverage;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Set<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(Set<Topping> toppings) {
        this.toppings = toppings;
    }

    public int getPizzaQuantity() {
        return pizzaQuantity;
    }

    public void setPizzaQuantity(int pizzaQuantity) {
        this.pizzaQuantity = pizzaQuantity;
    }

    public int getSidesQuantity() {
        return sidesQuantity;
    }

    public void setSidesQuantity(int sidesQuantity) {
        this.sidesQuantity = sidesQuantity;
    }

    public int getBeverageQuantity() {
        return beverageQuantity;
    }

    public void setBeverageQuantity(int beverageQuantity) {
        this.beverageQuantity = beverageQuantity;
    }

    public BigDecimal getOi_price() {
        return oi_price;
    }

    public void setOi_price(BigDecimal oi_price) {
        this.oi_price = oi_price;
    }
}

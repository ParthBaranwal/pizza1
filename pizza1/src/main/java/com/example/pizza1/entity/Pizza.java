package com.example.pizza1.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "pizzas")
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long p_id;

    private String pizza_name;
    private String description;
    private BigDecimal pizza_price;

    @Enumerated(EnumType.STRING)
    private Size size;

    @Enumerated(EnumType.STRING)
    private Crust crust;

    public enum Size {
        SMALL, MEDIUM, LARGE
    }

    public enum Crust {
        THIN, PAN, HANDTOSSED, CHEESEBURST
    }

    // Getters and Setters
    public Long getP_id() {
        return p_id;
    }

    public void setP_id(Long p_id) {
        this.p_id = p_id;
    }

    public String getPizza_name() {
        return pizza_name;
    }

    public void setPizza_name(String pizza_name) {
        this.pizza_name = pizza_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPizza_price() {
        return pizza_price;
    }

    public void setPizza_price(BigDecimal pizza_price) {
        this.pizza_price = pizza_price;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Crust getCrust() {
        return crust;
    }

    public void setCrust(Crust crust) {
        this.crust = crust;
    }
}

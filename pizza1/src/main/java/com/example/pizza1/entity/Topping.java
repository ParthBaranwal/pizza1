package com.example.pizza1.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "toppings")
public class Topping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long t_id;

    private String top_name;
    private BigDecimal top_price;

    public Long getT_id() {
        return t_id;
    }

    public void setT_id(Long t_id) {
        this.t_id = t_id;
    }

    public BigDecimal getTop_price() {
        return top_price;
    }

    public void setTop_price(BigDecimal top_price) {
        this.top_price = top_price;
    }

    public String getTop_name() {
        return top_name;
    }

    public void setTop_name(String top_name) {
        this.top_name = top_name;
    }
}

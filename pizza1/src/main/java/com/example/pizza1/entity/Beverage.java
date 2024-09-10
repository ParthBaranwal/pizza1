package com.example.pizza1.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "beverages")
public class Beverage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long b_id;

    private String b_name;

    private BigDecimal b_price;
    private String b_desc;

    public Long getB_id() {
        return b_id;
    }

    public void setB_id(Long b_id) {
        this.b_id = b_id;
    }



    public String getB_desc() {
        return b_desc;
    }

    public void setB_desc(String b_desc) {
        this.b_desc = b_desc;
    }

    public BigDecimal getB_price() {
        return b_price;
    }

    public void setB_price(BigDecimal b_price) {
        this.b_price = b_price;
    }

    public String getB_name() {
        return b_name;
    }

    public void setB_name(String b_name) {
        this.b_name = b_name;
    }
}

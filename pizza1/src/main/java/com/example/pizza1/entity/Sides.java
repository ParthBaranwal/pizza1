package com.example.pizza1.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table (name="sides")
public class Sides {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long s_id;

    private String s_name;
    private BigDecimal s_price;
    private String s_desc;



    public Long getS_id() {
        return s_id;
    }

    public void setS_id(Long s_id) {
        this.s_id = s_id;
    }



    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public BigDecimal getS_price() {
        return s_price;
    }

    public void setS_price(BigDecimal s_price) {
        this.s_price = s_price;
    }

    public String getS_desc() {
        return s_desc;
    }

    public void setS_desc(String s_desc) {
        this.s_desc = s_desc;
    }
}

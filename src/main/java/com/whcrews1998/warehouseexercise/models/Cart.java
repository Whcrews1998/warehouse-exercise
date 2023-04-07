package com.whcrews1998.warehouseexercise.models;

import jakarta.persistence.*;

@Entity
public class Cart {
    @Id
    @GeneratedValue
    private Integer id;

    public Cart() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}

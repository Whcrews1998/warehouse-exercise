package com.whcrews1998.warehouseexercise.entities;

import com.whcrews1998.warehouseexercise.models.Cart;
import com.whcrews1998.warehouseexercise.embeddable.Name;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name="user_details")
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    @Embedded
    private Name name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Order> orderList;


    public User() {
        this.orderList = new ArrayList<Order>();
    }

    public User(Integer id, Name name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}


// TODO Add Order History
// TODO Add Cart
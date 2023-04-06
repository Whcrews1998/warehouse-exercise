package com.whcrews1998.warehouseexercise.user;

import com.whcrews1998.warehouseexercise.cart.Cart;
import jakarta.persistence.*;

@Entity(name="user_details")
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    @Embedded
    private Name name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="cart_id")
    private Cart cart;

    public User() {
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
}


// TODO Add Order History
// TODO Add Cart
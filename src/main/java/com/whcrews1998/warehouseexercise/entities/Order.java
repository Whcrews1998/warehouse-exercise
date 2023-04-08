package com.whcrews1998.warehouseexercise.entities;

import com.whcrews1998.warehouseexercise.embeddable.Name;
import jakarta.persistence.*;

@Entity(name="orders")
public class Order {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    private Name user_name;

    public Order() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Name getUser_name() {
        return user_name;
    }

    public void setUser_name(Name user_name) {
        this.user_name = user_name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

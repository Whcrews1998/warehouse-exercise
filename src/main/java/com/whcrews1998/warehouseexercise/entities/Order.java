package com.whcrews1998.warehouseexercise.entities;

import com.whcrews1998.warehouseexercise.embeddable.Name;
import jakarta.persistence.*;

import java.util.List;

@Entity(name="orders")
public class Order {
    @Id
    @GeneratedValue
    private Integer id;

    private Name user_name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="order_id")
    private List<OrderDetails> orderDetailsList;

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

    public List<OrderDetails> getOrderDetailsList() {
        return orderDetailsList;
    }

    public void setOrderDetailsList(List<OrderDetails> orderDetailsList) {
        this.orderDetailsList = orderDetailsList;
    }
}
/* TODO: Add a OrderDetails List in this class and make sure cascade is set to 'ALL'. Only have to save Order instead of Order AND Order Detail.

 */
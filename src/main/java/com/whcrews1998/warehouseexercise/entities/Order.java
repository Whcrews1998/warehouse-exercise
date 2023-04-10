package com.whcrews1998.warehouseexercise.entities;

import com.whcrews1998.warehouseexercise.embeddable.Name;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name="orders")
public class Order {
    @Id
    @GeneratedValue
    private Integer id;

    private Name userName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="order_id")
    private List<OrderDetails> orderDetailsList;

    public Order() {
        this.orderDetailsList = new ArrayList<OrderDetails>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Name getUserName() {
        return userName;
    }

    public void setUserName(Name userName) {
        this.userName = userName;
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
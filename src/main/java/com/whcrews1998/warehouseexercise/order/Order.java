package com.whcrews1998.warehouseexercise.order;

import com.whcrews1998.warehouseexercise.embeddable.Name;
import com.whcrews1998.warehouseexercise.item.Item;
import com.whcrews1998.warehouseexercise.orderDetails.OrderDetails;
import jakarta.persistence.*;
import org.hibernate.mapping.Join;

import java.util.List;

@Entity(name="orders")
public class Order {
    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany
    @JoinColumn(name="order_id")
    private List<OrderDetails> orderDetailsList;

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
}

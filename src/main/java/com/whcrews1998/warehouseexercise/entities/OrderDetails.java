package com.whcrews1998.warehouseexercise.entities;

import com.whcrews1998.warehouseexercise.entities.Item;
import com.whcrews1998.warehouseexercise.entities.Order;
import jakarta.persistence.*;

@Entity
public class OrderDetails {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne()
    @JoinColumn(name="item_id")
    private Item item;

    public OrderDetails() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}

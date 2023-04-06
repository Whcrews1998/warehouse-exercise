package com.whcrews1998.warehouseexercise.cart;

import com.whcrews1998.warehouseexercise.item.Item;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cart {
    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany
    @JoinColumn(name="cart_id")
    private List<Item> itemList;

    public Cart() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}

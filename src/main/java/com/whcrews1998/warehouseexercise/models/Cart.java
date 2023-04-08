package com.whcrews1998.warehouseexercise.models;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Cacheable
public class Cart {

    private Integer id;
    private List<ItemInfo> itemList;

    public Cart() {
        this.itemList = new ArrayList<>();
    }

    public Cart(Integer id, List<ItemInfo> itemList) {
        this.id = id;
        this.itemList = itemList;
    }

    public void addToCart(ItemInfo item) {
        itemList.add(item);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<ItemInfo> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemInfo> itemList) {
        this.itemList = itemList;
    }
}

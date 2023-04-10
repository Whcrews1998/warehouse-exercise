package com.whcrews1998.warehouseexercise.repository;

import com.whcrews1998.warehouseexercise.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemService extends JpaRepository<Item, Integer> {
}

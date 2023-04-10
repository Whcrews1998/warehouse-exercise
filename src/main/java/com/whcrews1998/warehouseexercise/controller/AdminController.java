package com.whcrews1998.warehouseexercise.controller;

import com.whcrews1998.warehouseexercise.entities.Item;
import com.whcrews1998.warehouseexercise.models.ItemInfo;
import com.whcrews1998.warehouseexercise.repository.ItemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

// Used to Add Items to the Repository
@Controller
public class AdminController {
    private ItemService itemService;

    public AdminController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/items/add-item")
    private ResponseEntity<ItemInfo> addItemToRepository(@Valid @RequestBody ItemInfo itemInfo) {
        // TODO: Implement addItemToRepository Method
        return new ResponseEntity<ItemInfo>(itemInfo, HttpStatus.OK);
    }

    @PostMapping("/items/add-item-list")
    private ResponseEntity<List<Item>> addItemListToRepository(@Valid @RequestBody List<Item> itemList) {
        itemService.saveAll(itemList);
        return new ResponseEntity<>(itemList, HttpStatus.OK);
    }

    @GetMapping("/items")
    private ResponseEntity<List<Item>> getAllItems() {
        return new ResponseEntity<List<Item>>(itemService.findAll(), HttpStatus.OK);
    }
}

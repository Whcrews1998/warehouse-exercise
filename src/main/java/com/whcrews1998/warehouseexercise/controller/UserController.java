package com.whcrews1998.warehouseexercise.controller;

import com.whcrews1998.warehouseexercise.embeddable.Name;
import com.whcrews1998.warehouseexercise.entities.Item;
import com.whcrews1998.warehouseexercise.entities.Order;
import com.whcrews1998.warehouseexercise.entities.OrderDetails;
import com.whcrews1998.warehouseexercise.entities.User;
import com.whcrews1998.warehouseexercise.models.Cart;
import com.whcrews1998.warehouseexercise.models.ItemInfo;
import com.whcrews1998.warehouseexercise.repository.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    private Cart getOrCreateCart(HttpSession session) {
        Cart cart = (Cart)session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        return cart;
    }

    @GetMapping("/users/carts/get-cart")
    public ResponseEntity<Cart> getCart(HttpSession session) {
        String sessionId = session.getId();
        Cart cart = getOrCreateCart(session);

        return new ResponseEntity<Cart>(cart, HttpStatus.OK);
    }

    @PostMapping("/users/carts/add-to-cart")
    public ResponseEntity<Cart> addToCart(@RequestBody ItemInfo item, HttpSession session) {
        String sessionId = session.getId();
        Cart cart = getOrCreateCart(session);
        cart.addToCart(item);

        return new ResponseEntity<Cart>(cart, HttpStatus.OK);
    }

    @GetMapping("/users/checkout")
    public ResponseEntity<List<OrderDetails>> checkout( HttpSession session) {
        Cart cart = getOrCreateCart(session);
        // Optional<User> user = userService.findById(userId);
        User user = new User();
        user.setName(new Name("Harris", "Crews"));

        if (cart == null) return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);

        // Create Order
        Order order = new Order();
        order.setUserName(user.getName());


        // Save Order Details
        for (ItemInfo itemInfo: cart.getItemList()) {
            Item item = new Item();
            item.setId(itemInfo.getId());
            item.setPrice(itemInfo.getPrice());
            item.setName(itemInfo.getName());
            item.setCategory(itemInfo.getCategory());

            // Create Order Details
            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setItem(item);
            //Save to Order
            order.getOrderDetailsList().add(orderDetails);
        }

        // Add to User
        user.getOrderList().add(order);
        userService.save(user);

        return new ResponseEntity<>(order.getOrderDetailsList(), HttpStatus.OK);
    }

    @GetMapping("/set-timeout/{timeout}")
    public ResponseEntity<Integer> setTimeout(@PathVariable Integer timeout, HttpSession session) {
        session.setMaxInactiveInterval(timeout);
        return new ResponseEntity<>(timeout, HttpStatus.OK);
    }

}

// TODO: Create Checkout API
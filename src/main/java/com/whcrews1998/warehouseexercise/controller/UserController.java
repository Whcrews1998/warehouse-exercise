package com.whcrews1998.warehouseexercise.controller;

import com.whcrews1998.warehouseexercise.models.Cart;
import com.whcrews1998.warehouseexercise.models.ItemInfo;
import com.whcrews1998.warehouseexercise.repository.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/set-timeout/{timeout}")
    public ResponseEntity<Integer> setTimeout(@PathVariable Integer timeout, HttpSession session) {
        session.setMaxInactiveInterval(timeout);
        return new ResponseEntity<>(timeout, HttpStatus.OK);
    }

    @GetMapping("/store-name/{name}")
    public ResponseEntity<String> storeName(@PathVariable String name, HttpSession session) {
        String sessionId = session.getId();
        session.setAttribute("name", name);
        return new ResponseEntity<String>(name, HttpStatus.OK);
    }

    @GetMapping("/get-name")
    public ResponseEntity<String> getName( HttpSession session) {
        return new ResponseEntity<String>((String)session.getAttribute("name"), HttpStatus.OK);
    }
}

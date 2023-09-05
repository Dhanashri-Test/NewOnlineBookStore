package com.online.bookstore.demo.controller;

import com.online.bookstore.demo.entity.Book;
import com.online.bookstore.demo.entity.Customer;
import com.online.bookstore.demo.entity.ShoppingCart;
import com.online.bookstore.demo.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/shoppingcart")
public class ShoppingCartController {

    @Autowired
    ShoppingCartService shoppingCartService;

    @GetMapping()
    public ResponseEntity<Set<ShoppingCart>> getAllItems(@RequestParam("username") String username)
    {
        Set<ShoppingCart> shopping=shoppingCartService.getAllItems(username);
        return  new ResponseEntity<>(shopping, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<String> addItem(@RequestParam String username, @RequestBody Book book)
    {
        String message=shoppingCartService.addItem(username,book);
        return  new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteItem(@RequestParam String username, @RequestBody Book book)
    {
        String message=shoppingCartService.removeItem(username,book);
        return  new ResponseEntity<>(message, HttpStatus.OK);
    }
}

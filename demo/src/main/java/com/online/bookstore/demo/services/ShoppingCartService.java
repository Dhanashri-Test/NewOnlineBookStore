package com.online.bookstore.demo.services;

import com.online.bookstore.demo.entity.Book;
import com.online.bookstore.demo.entity.Customer;
import com.online.bookstore.demo.entity.ShoppingCart;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface ShoppingCartService {

    public Set<ShoppingCart> getAllItems(String username);

    public String addItem(String username, Book book);

    public String removeItem(String username, Book book);


}

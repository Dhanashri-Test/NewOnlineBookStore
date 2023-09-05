package com.online.bookstore.demo.services;

import com.online.bookstore.demo.entity.Book;
import com.online.bookstore.demo.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface BookUserService {

    Set<Book> getBooksPurchasedBy(Customer customer);
}

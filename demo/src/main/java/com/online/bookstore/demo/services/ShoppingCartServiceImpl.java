package com.online.bookstore.demo.services;

import com.online.bookstore.demo.entity.Book;
import com.online.bookstore.demo.entity.Customer;
import com.online.bookstore.demo.entity.ShoppingCart;
import com.online.bookstore.demo.exception.ResourceNotFoundException;
import com.online.bookstore.demo.repository.CustomerRepository;
import com.online.bookstore.demo.repository.ShoppingCartRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{

    @Autowired
    private CustomerRepository theCustomerRepository;

    @Autowired
    private ShoppingCartRepository theCartRepository;
    @Override
    @Transactional
    public Set<ShoppingCart> getAllItems(String username) {
        Set<ShoppingCart> items = new HashSet<ShoppingCart>();
        items.addAll(theCartRepository.getItemsByCustomer(username));
        return items;
    }

    @Override
    @Transactional
    public String addItem(String username, Book book) {
        int count=theCartRepository.addByIds(username,book.getId(),1);
        Customer customer=theCustomerRepository.findById(username).orElseThrow(()->new ResourceNotFoundException("Customer","Customer ID",username));
//        if(count > 0) {
//            customer.addShoppingCart(new ShoppingCart(customer,book,1));
//        }
        return "Book added successfully to customer cart";
    }

    @Override
    @Transactional
    public String removeItem(String username, Book book) {
        int count=theCartRepository.removeByIds(username,book.getId());
        if(count > 0) {
            return "Book Removed successfully to customer cart";
        }
        else
            throw new ResourceNotFoundException("Customer","Customer ID",username);
    }


}

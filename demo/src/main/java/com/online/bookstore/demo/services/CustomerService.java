package com.online.bookstore.demo.services;

import com.online.bookstore.demo.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    public List<Customer> getAllCustomers();

    public Customer getCustomer(String username);

    public String saveCustomer(Customer theCustomer);

    public String updateCustomer(Customer theCustomer,String username);

    public String removeCustomer(String username);


}

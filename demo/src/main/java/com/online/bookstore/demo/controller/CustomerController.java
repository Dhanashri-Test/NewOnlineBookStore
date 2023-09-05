package com.online.bookstore.demo.controller;

import com.online.bookstore.demo.entity.Book;
import com.online.bookstore.demo.entity.Customer;
import com.online.bookstore.demo.entity.User;
import com.online.bookstore.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

        @Autowired
        CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers()
    {
        List<Customer> customerList=customerService.getAllCustomers();
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<Customer> getCustomerByID(@PathVariable("username") String username)
    {
        Customer cust=customerService.getCustomer(username);
        return new ResponseEntity<>(cust, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer)
    {
        String message=customerService.saveCustomer(customer);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("username") String username)
    {
        String message=customerService.removeCustomer(username);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCustomer(@RequestBody Customer customer,@PathVariable("id") String id)
    {
        String message=customerService.updateCustomer(customer,id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}

package com.online.bookstore.demo.services;

import com.online.bookstore.demo.entity.Customer;
import com.online.bookstore.demo.entity.User;
import com.online.bookstore.demo.exception.ResourceNotFoundException;
import com.online.bookstore.demo.repository.CustomerRepository;
import com.online.bookstore.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<Customer> getAllCustomers() {

        List<Customer> customersList=customerRepository.findAll();
        return customersList;
    }

    @Override
    public Customer getCustomer(String username) {

        Customer customer= customerRepository.findById(username).orElseThrow(()->new ResourceNotFoundException("Customer","Customer ID",username));

        return customer;
    }

    @Override
    public String saveCustomer(Customer customer) {

        customerRepository.save(customer);
       // User user=customer.getUser();
      //  userRepository.save(user);
        return "Customer Added Successfully";
    }

    @Override
    public String updateCustomer(Customer customer,String username) {
        Customer customer1=customerRepository.findById(username).orElseThrow(()->new ResourceNotFoundException("Customer","Customer ID",username));
        customer1.setMobile(customer.getMobile());
        customer1.setAddress(customer.getAddress());
        customerRepository.save(customer1);
        return "Customer updated Successfully";
    }

    @Override
    public String removeCustomer(String username) {
        customerRepository.deleteById(username);
        return "Customer deleted Successfully";
    }
}

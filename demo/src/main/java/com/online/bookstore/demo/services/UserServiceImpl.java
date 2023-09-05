package com.online.bookstore.demo.services;

import com.online.bookstore.demo.entity.User;
import com.online.bookstore.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;
    @Override
    public List<User> getAllUserList() {
        List<User> users= new ArrayList<>();
            users.addAll(userRepository.findAll());
        return users;
    }

    @Override
    public User getUserByUserName(String username) {
        User user= userRepository.findById(username).orElseThrow(()-> new RuntimeException("User not found"));
        return user;
    }

    @Override
    public User saveUser(User user) {
        User user1= userRepository.save(user);
        return user1;
    }
}

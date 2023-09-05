package com.online.bookstore.demo.services;

import com.online.bookstore.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public List<User> getAllUserList();
    public User getUserByUserName(String username);

    public User saveUser(User user);

}

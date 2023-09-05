package com.online.bookstore.demo.controller;

import com.online.bookstore.demo.entity.User;
import com.online.bookstore.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

        @Autowired
        UserService userService;

        @GetMapping
        public ResponseEntity<List<User>> getAllUsers()
        {
            List<User> userList=userService.getAllUserList();
            return new ResponseEntity<>(userList, HttpStatus.OK);
        }

        @GetMapping("/{username}")
        public ResponseEntity<User> getUserByUserName(@PathVariable("username") String username)
        {
            User user= userService.getUserByUserName(username);
            return new ResponseEntity<>(user,HttpStatus.OK);
        }

        @PostMapping
        public ResponseEntity<User> saveUser(@RequestBody User user)
        {
            User user1= userService.saveUser(user);
            return new ResponseEntity<>(user,HttpStatus.OK);
        }


}

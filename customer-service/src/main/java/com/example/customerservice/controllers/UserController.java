package com.example.customerservice.controllers;

import com.example.customerservice.models.UserModel;
import com.example.customerservice.services.UserService;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    Gson g;
    
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/customer/user/create")
    public String createUser(UserModel userModel) {
        return userService.createUser(userModel);
    }
}
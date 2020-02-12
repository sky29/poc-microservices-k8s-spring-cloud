package com.example.customerservice.services;

import com.example.customerservice.models.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    KeycloakService keyCloakService;

    public String createUser(UserModel userModel) {
        return keyCloakService.createUser(userModel);
    }
}
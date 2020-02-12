package com.example.customerservice.models;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
public class UserModel {

    @Getter @Setter
    private String userName;

    @Getter @Setter
    private String firstName;

    @Getter @Setter
    private String lastName;

    @Getter @Setter
    private String emailAddress;

    @Getter @Setter
    private String password;
    
}
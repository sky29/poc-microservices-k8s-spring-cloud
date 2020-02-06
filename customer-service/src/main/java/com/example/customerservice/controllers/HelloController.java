package com.example.customerservice.controllers;

import com.example.customerservice.models.HelloModel;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    HelloModel helloModel;

    @Autowired
    Gson g;
    
    @GetMapping("/customer/hello")
    public String getHello() {
        return g.toJson(helloModel);
    }
}
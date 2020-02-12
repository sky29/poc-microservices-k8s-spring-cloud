package com.example.marketservice.controllers;

import com.example.marketservice.models.HelloModel;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    HelloModel helloModel;

    @Autowired
    Gson g;
    
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/market/hello")
    public String getHello() {
        return g.toJson(helloModel);
    }
}
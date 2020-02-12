package com.example.integrationservice.controllers;

import com.example.integrationservice.models.HelloModel;
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
    @GetMapping("/integration/hello")
    public String getHello() {
        return g.toJson(helloModel);
    }
}
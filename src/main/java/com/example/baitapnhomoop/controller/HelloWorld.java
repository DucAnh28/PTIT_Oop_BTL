package com.example.baitapnhomoop.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world")
@CrossOrigin("*")
public class HelloWorld {

    @GetMapping
    public String helloWorld() {
        return "Hello World";
    }
}

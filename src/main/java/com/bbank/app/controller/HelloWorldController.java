package com.bbank.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(name = "/sayHello")
    public String sayHello() {
        return "Hello World";
    }
}

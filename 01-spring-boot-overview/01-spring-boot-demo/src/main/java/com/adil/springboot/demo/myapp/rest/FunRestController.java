package com.adil.springboot.demo.myapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${my.name}")
    private String myName;

    // expost "/" that return "Hello world"
    @GetMapping("/")
    public String sayHello() {
        System.out.println(myName);
        return "Hello WOrld";
    }

}

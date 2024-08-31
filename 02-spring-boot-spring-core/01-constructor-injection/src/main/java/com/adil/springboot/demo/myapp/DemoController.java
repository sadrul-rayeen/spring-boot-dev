package com.adil.springboot.demo.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for the dependency
    private Coach myCoach;

    // define a constructor for dependency injection
    @Autowired
    public DemoController(Coach coach) {
        myCoach = coach;
    }

    @GetMapping("/dailyWorkOut")
    public String getDailyWorkOut() {
        return myCoach.getDailyWorkOut();
    }
}

package com.adil.springboot.demo.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for the dependency
    private Coach myCoach;

    // setter injection
    @Autowired
    public void setCoach(Coach theCoach) {
        myCoach = theCoach;
    }
    

    @GetMapping("/dailyWorkOut")
    public String getDailyWorkOut() {
        return myCoach.getDailyWorkOut();
    }
}

package com.adil.springboot.demo.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for the dependency
    private Coach myCoach;

    // Qualifier for constructor injection
    @Autowired
    public DemoController(@Qualifier("tennisCoach") Coach theCoach) {
        myCoach = theCoach;
    }
    

    @GetMapping("/dailyWorkOut")
    public String getDailyWorkOut() {
        return myCoach.getDailyWorkOut();
    }
}

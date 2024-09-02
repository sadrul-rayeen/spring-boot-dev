package com.adil.springboot.demo.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {

    public TrackCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Autowired
    public String getDailyWorkOut() {
        return "Please run atleast 10 mins";
    }
}

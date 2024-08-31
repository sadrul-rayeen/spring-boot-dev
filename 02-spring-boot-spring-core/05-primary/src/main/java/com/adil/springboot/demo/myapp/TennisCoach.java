package com.adil.springboot.demo.myapp;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    @Override
    public String getDailyWorkOut() {
        return "Please walk atleast 30 mins daily!!!";
    }

}

package com.adil.springboot.demo.myapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // inject properties form : coach.name and team.name
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    // expose new endpoint for "teaminfo"

    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return "Coach: " + coachName + ", Team name: " + teamName;
    }

    @Value("${my.name}")
    private String myName;

    // expost "/" that return "Hello world"
    @GetMapping("/")
    public String sayHello() {
        System.out.println(myName);
        return "Hello WOrld";
    }

    // expose a new endpoint for "workout"

    @GetMapping("/workout")
    public String getDailyWorlOut() {
        return "Run a hard 5k!";
    }

    @GetMapping("/break")
    public String getBreak() {
        return "Take a break after 10 mins";
    }



}

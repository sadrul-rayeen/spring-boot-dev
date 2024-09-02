package com.adil.springboot.demo.myapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.adil.springboot.demo.myapp.Coach;
import com.adil.springboot.demo.myapp.SwimCoach;

@Configuration
public class SportsConfig {
    @Bean
    public Coach swimCoach() {
        return new SwimCoach();
    }
}

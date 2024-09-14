package com.adil.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.adil.springboot.thymeleafdemo.model.Student;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @Value("${systems}")
    private List<String> systems;

    @GetMapping("/showStudentForm")
    public String showForm(Model thModel) {

        // create a student object
        Student theStudent = new Student();

        // add a student object to the model
        thModel.addAttribute("student", theStudent);
        thModel.addAttribute("countries", countries);
        thModel.addAttribute("languages", languages);
        thModel.addAttribute("systems", systems);

        return "student-form";
    }

    @PostMapping("/processStudentFrom")
    public String processStudentFrom(@ModelAttribute("student") Student theStudent) {
        // log the input data

        System.out.printf("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName());

        return "student-confirmation";
    }

}

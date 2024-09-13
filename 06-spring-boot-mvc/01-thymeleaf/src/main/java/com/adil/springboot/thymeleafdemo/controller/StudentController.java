package com.adil.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.adil.springboot.thymeleafdemo.model.Student;

@Controller
public class StudentController {

    @GetMapping("/showStudentForm")
    public String showForm(Model thModel) {

        // create a student object
        Student theStudent = new Student();

        // add a student object to the model
        thModel.addAttribute("student", theStudent);

        return "student-form";
    }

    @PostMapping("/processStudentFrom")
    public String processStudentFrom(@ModelAttribute("student") Student theStudent) {
        // log the input data

        System.out.printf("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName());

        return "student-confirmation";
    }

}

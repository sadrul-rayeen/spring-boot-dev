package com.example.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    // define @PostConstruct to load the student data... only once
    @PostConstruct
    public void loadData() {
        theStudents  = new ArrayList<>();

        theStudents.add(new Student("Sadrul", "Vala"));
        theStudents.add(new Student("Sadrul1", "Vala1"));
        theStudents.add(new Student("Sadrul2", "Vala2"));
        theStudents.add(new Student("Sadrul3", "Vala3"));
    }
    // define endpoint for '/students' - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents() {

        return theStudents;
    }

    // define endpoint or "/students/{studentId}" - return student at index

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        //just index into the list... keep it simple for now
        // check the student id again the list size
        if (studentId >= theStudents.size() || studentId < 0) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        Student st = theStudents.get(studentId);
        return st;
    }
    
    // Add an exception hndler using @ExceptionHandler
    
}

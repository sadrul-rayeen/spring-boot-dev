package com.adil.cruddemo.dao;

import java.util.List;

import com.adil.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student thStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);
}

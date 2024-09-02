package com.adil.cruddemo.dao;

import com.adil.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student thStudent);

    Student findById(Integer id);
}

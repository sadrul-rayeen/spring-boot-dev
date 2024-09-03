package com.adil.springboot.demo.dao;

import java.util.List;

import com.adil.springboot.demo.entity.Employee;

public interface EmployeeDAO {
    List<Employee> findAll();
}

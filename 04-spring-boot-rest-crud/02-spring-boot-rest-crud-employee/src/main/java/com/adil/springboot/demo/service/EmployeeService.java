package com.adil.springboot.demo.service;

import java.util.List;

import com.adil.springboot.demo.entity.Employee;

public interface EmployeeService {
    List<Employee> findAll();
    
    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}

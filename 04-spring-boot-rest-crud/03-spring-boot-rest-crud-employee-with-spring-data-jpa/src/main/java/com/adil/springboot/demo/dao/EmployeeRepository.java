package com.adil.springboot.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adil.springboot.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // that's it ... no need to write any code!!
}

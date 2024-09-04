package com.adil.springboot.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adil.springboot.demo.entity.Employee;
import com.adil.springboot.demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    //quick and dirty: inject employee dao (use constructor injection)
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);

        if (null == theEmployee) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    // add mapping for PUT /employees - update existing employee

    @PutMapping("/employees")
    public Employee updatEmployee(@RequestBody Employee theEmployee) {
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee tempEmployee = employeeService.findById(employeeId);

        if (null == tempEmployee) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted employee id - " + employeeId;
    }


}

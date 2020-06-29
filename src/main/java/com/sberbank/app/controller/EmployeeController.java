package com.sberbank.app.controller;

import com.sberbank.app.model.Employee;
import com.sberbank.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/employee")
public class EmployeeController {

    EmployeeService employeeService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/employees")
    private List<Employee> findAll() {
        return employeeService.listAll();
    }

    @PostMapping("/save")
    private Employee saveEmployee(Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }
}


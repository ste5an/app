package com.sberbank.app.controller;

import com.sberbank.app.controller.dto.NewEmployeeInfoDto;
import com.sberbank.app.dao.model.Employee;
import com.sberbank.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/employee")
public class EmployeeController {


    //crud employee
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    private List<Employee> findAll() {
        return employeeService.findAll();
    }

    @PostMapping("/save")
    public void createEmployee(@RequestBody NewEmployeeInfoDto info){
        employeeService.save(info);
    }

    @DeleteMapping("/delete/{id}")
    private void deleteEmployee(@PathVariable("id") long id) {
        employeeService.deleteById(id);
    }
}

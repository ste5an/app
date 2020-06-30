package com.sberbank.app.controller;

import com.sberbank.app.controller.dto.NewEmployeeInfoDto;
import com.sberbank.app.dao.model.Employee;
import com.sberbank.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/rest/employee")
@Api(value = "User Controller", description = "communication between the user and the system")
public class EmployeeController {


    //crud employee
    @Autowired
    EmployeeService employeeService;

    @ApiOperation(value = "get all employees from DB")
    @GetMapping("/employees")
    private List<Employee> findAll() {
        return employeeService.findAll();
    }

    @ApiOperation(value = "save employee")
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createEmployee(@RequestBody NewEmployeeInfoDto info){
        employeeService.save(info);
    }

    @ApiOperation(value = "delete employee by id")
    @DeleteMapping("/delete/{id}")
    private void deleteEmployee(@PathVariable("id") long id) {
        employeeService.deleteById(id);
    }

    @ApiOperation(value = "find employee by id")
    @GetMapping("/find/{id}")
    private Employee getEmployee(@PathVariable("id") long id) {
        return employeeService.findById(id);
    }

    @ApiOperation(value = "update employee")
    @PutMapping("/update")
    private Employee update(@RequestBody Employee employee) {
        employeeService.update(employee);
        return employee;
    }
}

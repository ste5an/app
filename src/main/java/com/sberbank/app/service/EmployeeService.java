package com.sberbank.app.service;

import com.sberbank.app.controller.dto.NewEmployeeInfoDto;
import com.sberbank.app.dao.model.Employee;
import com.sberbank.app.dao.model.Team;
import com.sberbank.app.dao.repository.EmployeeRepository;
import com.sberbank.app.dao.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TeamRepository teamRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(Long id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new RuntimeException("Employee with id: " + id + " not found");
        }
    }

    @Transactional
    public void save(NewEmployeeInfoDto info) {
        Team team = teamRepository.findTeamByName(info.getTeamName());

        Employee employee = new Employee();
        employee.setAge(info.getAge());
        //todo
        employee.setTeam(team);
        employee.


        employeeRepository.save(employee);
    }

    @Transactional
    public void update(Employee employee) {
        Optional<Employee> optional = employeeRepository.findById(employee.getId());
        if (optional.isPresent()) {
            employeeRepository.save(optional.get());
        } else {
            throw new RuntimeException("Employee with id: " + employee.getId() + " not found");
        }
    }

    @Transactional
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }


}

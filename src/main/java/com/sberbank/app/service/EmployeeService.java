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
    public Employee save(NewEmployeeInfoDto info) {
        Team team = teamRepository.findTeamByName(info.getTeamName());

        Employee employee = new Employee();
        //todo
        employee.setTeam(team);
        employee.setFirstName(info.getFirstName());
        employee.setLastName(info.getLastName());
        employee.setGivenName(info.getGivenName());
        employee.setPosition(info.getPosition());
        employee.setAge(info.getAge());

        return employeeRepository.save(employee);
    }

    @Transactional
    public Employee update(Employee employee) {
        Optional<Employee> optional = employeeRepository.findById(employee.getId());
        if (optional.isPresent()) {
            Employee employeeFromDb = optional.get();
            employeeFromDb.setId(employee.getId());
            employeeFromDb.setPosition(employee.getPosition());
            employeeFromDb.setFirstName(employee.getLastName());
            employeeFromDb.setLastName(employee.getLastName());
            employeeFromDb.setGivenName(employee.getGivenName());
            employeeFromDb.setPosition(employee.getPosition());
            employeeFromDb.setAge(employee.getAge());
            return employeeRepository.save(employeeFromDb);
        } else {
            throw new RuntimeException("Employee with id: " + employee.getId() + " not found");
        }
    }

    @Transactional
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee findById(long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        //logger.info("Get user by passportId from DB: {}", userOptional);
        if (employeeOptional.isPresent()) {
            return employeeOptional.get();
        } else throw new RuntimeException("User not found");
    }
}

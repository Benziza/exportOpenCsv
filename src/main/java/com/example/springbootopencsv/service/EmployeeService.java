package com.example.springbootopencsv.service;

import com.example.springbootopencsv.model.Employee;
import com.example.springbootopencsv.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> fetchAll() {
        return (List<Employee>) employeeRepository.findAll();
    }
}
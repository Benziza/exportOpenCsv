package com.example.springbootopencsv.repository;

import com.example.springbootopencsv.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository
        extends CrudRepository<Employee, Long> {

}
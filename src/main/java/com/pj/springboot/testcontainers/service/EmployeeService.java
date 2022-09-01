package com.pj.springboot.testcontainers.service;

import com.pj.springboot.testcontainers.domain.Employee;
import com.pj.springboot.testcontainers.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    /**
     * Find all Employees in the system
     *
     * @return List of Employees in ascending order of name
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    List<Employee> findAll();

    /**
     * Create employee with given information
     *
     * @param employeeDTO contains new employee information
     *
     * @return Created employee
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    Employee create(EmployeeDTO employeeDTO);
}

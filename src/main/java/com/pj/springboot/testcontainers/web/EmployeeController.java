package com.pj.springboot.testcontainers.web;


import com.pj.springboot.testcontainers.domain.Employee;
import com.pj.springboot.testcontainers.dto.EmployeeDTO;
import com.pj.springboot.testcontainers.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Provides API endpoints to get, save and update Employee data
 *
 * @author Pavan Kumar Jadda
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Find all Employees in the system
     *
     * @return List of Employees in ascending order of name
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @GetMapping("/find/all")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

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
    @PostMapping("/create")
    public Employee create(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.create(employeeDTO);
    }
}

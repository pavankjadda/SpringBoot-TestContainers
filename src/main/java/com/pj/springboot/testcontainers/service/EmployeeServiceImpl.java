package com.pj.springboot.testcontainers.service;

import com.pj.springboot.testcontainers.domain.Employee;
import com.pj.springboot.testcontainers.dto.EmployeeDTO;
import com.pj.springboot.testcontainers.repository.EmployeeRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Service class that handles business logic to get Employees data
 *
 * @author Pavan Kumar Jadda
 * @since 1.0.0
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * Find all Employees in the system
     *
     * @return List of Employees in ascending order of name
     *
     * @author Pavan Kumar Jadda
     * @since 1.0.0
     */
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll(Sort.by("firstName"));
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
    @Override
    public Employee create(EmployeeDTO employeeDTO) {
        return employeeRepository.saveAndFlush(new Employee(employeeDTO.getFirstName(), employeeDTO.getLastName(), employeeDTO.getEmail(), employeeDTO.getPhone()));
    }
}

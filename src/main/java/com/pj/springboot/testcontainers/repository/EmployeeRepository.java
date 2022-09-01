package com.pj.springboot.testcontainers.repository;

import com.pj.springboot.testcontainers.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {}

package com.pj.springboot.testcontainers.domain;

import lombok.Data;

import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;

/**
 * Entity class that maps to the employee table in the database. This table is used to store the employees information.
 *
 * @author Pavan Kumar Jadaa
 * @since 1.0.0
 */
@Data
@Entity
@Table(name = "employee")
public class Employee implements Serializable {
    @Serial
    private static final long serialVersionUID = 2182895620228103840L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }
}

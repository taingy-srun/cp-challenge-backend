package com.taingy.curepatientchallenge.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @Column(name = "employee_id")
    private Integer employeeId;
    @NotNull(message = "Employee name is required")
    @NotEmpty
    @NotBlank
    @Column(nullable = false)
    private String name;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String supervisors;
}

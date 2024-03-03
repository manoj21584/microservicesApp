package com.springmicro.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springmicro.employeeservice.dto.EmployeeDto;
import com.springmicro.employeeservice.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
Employee findByEmail(String email);
}
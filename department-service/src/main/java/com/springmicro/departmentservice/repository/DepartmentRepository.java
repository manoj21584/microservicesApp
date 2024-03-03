package com.springmicro.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springmicro.departmentservice.dto.DepartmentDto;
import com.springmicro.departmentservice.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
	Department findByDepartmentCode(String code);
}

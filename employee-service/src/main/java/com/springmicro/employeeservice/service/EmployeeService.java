package com.springmicro.employeeservice.service;

import com.springmicro.employeeservice.dto.ApiResponseDto;
import com.springmicro.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
	EmployeeDto saveEmployee(EmployeeDto employeeDto);
	EmployeeDto getByEmail(String email);
	ApiResponseDto getById(Long id) throws Exception;


}


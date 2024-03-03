package com.springmicro.employeeservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmicro.employeeservice.dto.ApiResponseDto;
import com.springmicro.employeeservice.dto.EmployeeDto;
import com.springmicro.employeeservice.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	@PostMapping
	public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
		EmployeeDto dto=employeeService.saveEmployee(employeeDto);
	return new ResponseEntity<>(dto,HttpStatus.CREATED);
	}
	@GetMapping("/getbyemail/{email}")
	public ResponseEntity<EmployeeDto> getEmployeeByEmail(@PathVariable String email) {
		EmployeeDto dto=employeeService.getByEmail(email);
	return new ResponseEntity<>(dto,HttpStatus.OK);
	}
	@GetMapping("{id}")
	public ResponseEntity<ApiResponseDto> getEmployeeById(@PathVariable long id) throws Exception {
		ApiResponseDto dto=employeeService.getById(id);
	return new ResponseEntity<>(dto,HttpStatus.OK);
	}

}

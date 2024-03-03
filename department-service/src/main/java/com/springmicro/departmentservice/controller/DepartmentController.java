package com.springmicro.departmentservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmicro.departmentservice.dto.DepartmentDto;
import com.springmicro.departmentservice.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
	private DepartmentService departmentService;
	public DepartmentController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	@PostMapping
	public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
		DepartmentDto saveDepartment =departmentService.saveDepartment(departmentDto);
		
		return new ResponseEntity<>(saveDepartment,HttpStatus.CREATED);
		
	}
	@GetMapping("{code}")
	public ResponseEntity<DepartmentDto> getDepartmentByCOde(@PathVariable String code){
		DepartmentDto departmentDto =departmentService.getDepartmentByCode(code);
		return new ResponseEntity<>(departmentDto,HttpStatus.OK);
		
	}

}

package com.springmicro.departmentservice.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.springmicro.departmentservice.dto.DepartmentDto;
import com.springmicro.departmentservice.entity.Department;
import com.springmicro.departmentservice.repository.DepartmentRepository;
import com.springmicro.departmentservice.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	private DepartmentRepository departmentRepository;

	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}

	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
		Department department = new Department(
				departmentDto.getId(), 
				departmentDto.getDepartmentName(),
				departmentDto.getDepartmentDescription(),
				departmentDto.getDepartmentCode());
		Department saveDepartment=departmentRepository.save(department);
		DepartmentDto saveDepartmentDto= new DepartmentDto(
				saveDepartment.getId(),
				saveDepartment.getDepartmentName(),
				saveDepartment.getDepartmentDescription(),
				saveDepartment.getDepartmentCode());
		
		return saveDepartmentDto;
	}

	@Override
	public DepartmentDto getDepartmentByCode(String departmentCode) {
		Department department=departmentRepository.findByDepartmentCode(departmentCode);
		DepartmentDto departmentDto=new DepartmentDto(
				department.getId(),
				department.getDepartmentName(),
				department.getDepartmentDescription(),
				department.getDepartmentCode()
				);
				
		return departmentDto;
	}

}

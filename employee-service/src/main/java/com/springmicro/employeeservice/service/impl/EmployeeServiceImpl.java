package com.springmicro.employeeservice.service.impl;

//import com.springmicro.departmentservice.dto.DepartmentDto;

import com.springmicro.employeeservice.dto.DepartmentDto;
import com.springmicro.employeeservice.dto.EmployeeDto;
import com.springmicro.employeeservice.dto.OrganisationDto;
//import com.springmicro.employeeservice.service.APIClient;
//import com.springmicro.employeeservice.service.APIClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient;

import com.springmicro.employeeservice.dto.ApiResponseDto;
//import com.springmicro.employeeservice.dto.EmployeeDto;
import com.springmicro.employeeservice.entity.Employee;
import com.springmicro.employeeservice.exception.ResourceNotFoundException;
import com.springmicro.employeeservice.repository.EmployeeRepository;
import com.springmicro.employeeservice.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeRepository employeeRepository;
//	private RestTemplate restTemplate;
	private WebClient webClient;
//	private APIClient apiClient;



	

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		Employee employee = new Employee(employeeDto.getId(), employeeDto.getFirstName(), employeeDto.getLastName(),
				employeeDto.getEmail(), employeeDto.getDepartmentCode(),employeeDto.getOrganisationCode());
		Employee saveEmployee = employeeRepository.save(employee);
		EmployeeDto saveEmployeeDto = new EmployeeDto(saveEmployee.getId(), saveEmployee.getFirstName(),
				saveEmployee.getLastName(), saveEmployee.getEmail(), saveEmployee.getDepartmentCode(),saveEmployee.getOrganisationCode());
		return saveEmployeeDto;
	}



	@Override
	public EmployeeDto getByEmail(String email) {
		Employee saveEmployee = employeeRepository.findByEmail(email);
		if(saveEmployee==null) {
			throw new ResourceNotFoundException("Resource with given email:"+email+"doesn't exist");
		}
		EmployeeDto saveEmployeeDto = new EmployeeDto(saveEmployee.getId(), saveEmployee.getFirstName(),
				saveEmployee.getLastName(), saveEmployee.getEmail(), saveEmployee.getDepartmentCode(),saveEmployee.getOrganisationCode());
		return saveEmployeeDto;
	}

//	@Override
//	public ApiResponseDto getById(Long id) throws Exception {
//		return null;
//	}

	@Override
	public ApiResponseDto getById(Long id) throws Exception {
		Employee saveEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("resource with given id:"+id+"not found"));

		//RestTemplate
//		ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8082/api/departments/"+saveEmployee.getDepartmentCode(),DepartmentDto.class);
//		DepartmentDto departmentDto=responseEntity.getBody();
	
//		//webclient
		DepartmentDto departmentDto=webClient.get().uri("http://localhost:8082/api/departments/"+saveEmployee.getDepartmentCode())
		.retrieve()
		.bodyToMono(DepartmentDto.class)
		.block();
		OrganisationDto organisationDto=webClient.get().uri("http://localhost:8083/api/organisations/"+saveEmployee.getOrganisationCode())
				.retrieve()
				.bodyToMono(OrganisationDto.class)
				.block();
//		DepartmentDto departmentDto = apiClient.getDepartmentByCode(saveEmployee.getDepartmentCode());
//      OrganisationDto organisationDto1 = apiClient.getOrganisationByCode(saveEmployee.getOrganisationCode());

		EmployeeDto saveEmployeeDto = new EmployeeDto(saveEmployee.getId(), saveEmployee.getFirstName(),
				saveEmployee.getLastName(), saveEmployee.getEmail(), saveEmployee.getDepartmentCode(),saveEmployee.getOrganisationCode());
		
		ApiResponseDto apiResponseDto=new ApiResponseDto();
		apiResponseDto.setEmployee(saveEmployeeDto);
		apiResponseDto.setDepartment(departmentDto);
		apiResponseDto.setOrganisation(organisationDto);
		return apiResponseDto;
	}

}

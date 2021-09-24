package com.lightfeather.code.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.lightfeather.code.domain.Employee;

@Service
public interface EmployeeService {
	
	Employee createEmployee(@Valid Employee employee);

}

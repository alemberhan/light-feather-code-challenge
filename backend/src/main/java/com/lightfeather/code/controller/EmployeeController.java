package com.lightfeather.code.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lightfeather.code.domain.Employee;
import com.lightfeather.code.service.SupervisorService;
import com.lightfeather.code.util.EmployeeValidationException;
import com.lightfeather.code.util.StringUtil;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class EmployeeController {

	private final Logger log = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	SupervisorService supervisorService;

	@GetMapping("/supervisors")
	public ResponseEntity<List<String>> getAllSupervisors() throws Exception {

		return ResponseEntity.ok().headers(new HttpHeaders()).body(supervisorService.getAllSupervisors());
	}

	@PostMapping("/employees")
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) throws Exception {
		log.info("REST request to create Employee : {}", employee);
		
		if(StringUtil.isEmpty(employee.getFirstName()) || StringUtil.isEmpty(employee.getLastName()) || StringUtil.isEmpty(employee.getSupervisor())) {
			throw new EmployeeValidationException();
		}

		return ResponseEntity.ok().headers(new HttpHeaders()).body(employee);
	}

}

package com.lightfeather.code.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface SupervisorService {
	
	List<String> getAllSupervisors();

}

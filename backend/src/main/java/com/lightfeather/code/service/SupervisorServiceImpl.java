package com.lightfeather.code.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lightfeather.code.domain.Supervisor;
import com.lightfeather.code.util.StringUtil;

@Service
public class SupervisorServiceImpl implements SupervisorService {

	public static final String URL = "https://o3m5qixdng.execute-api.us-east-1.amazonaws.com/api/managers";

	@Override
	public List<String> getAllSupervisors() {
		RestTemplate restTemplate = new RestTemplate();
		List<String> supervisors = Arrays.asList(restTemplate.getForObject(URL, Supervisor[].class)).stream()
				.filter(s -> !StringUtil.isNumeric(s.getJurisdiction())).sorted().map(Supervisor::toString).collect(Collectors.toList());

		return supervisors;
	}

}

package com.lightfeather.code;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.lightfeather.code.service.SupervisorService;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
/*
	@Bean
	public CommandLineRunner demo(SupervisorService service) {
		return (args) -> {

			// fetch all Supervisor
			log.info("Supervisors found with getAllSupervisors():");
			log.info("-------------------------------");
			for (String supervisor : service.getAllSupervisors()) {
				log.info(supervisor);
			}
		};
	}
	*/

}

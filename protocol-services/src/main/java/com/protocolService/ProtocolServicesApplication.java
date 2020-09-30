package com.protocolService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ProtocolServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProtocolServicesApplication.class, args);
	}

}

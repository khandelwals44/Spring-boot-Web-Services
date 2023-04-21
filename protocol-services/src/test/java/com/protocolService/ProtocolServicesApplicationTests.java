package com.protocolService;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@EnableAutoConfiguration
class ProtocolServicesApplicationTests extends ProtocolServicesApplication {

	@Test
	void contextLoads() {
		ProtocolServicesApplication.main(new String[] {});

	}

}

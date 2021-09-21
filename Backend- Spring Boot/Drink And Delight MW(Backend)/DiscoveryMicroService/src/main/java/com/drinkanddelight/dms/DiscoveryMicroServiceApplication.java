package com.drinkanddelight.dms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryMicroServiceApplication.class, args);
	}

}

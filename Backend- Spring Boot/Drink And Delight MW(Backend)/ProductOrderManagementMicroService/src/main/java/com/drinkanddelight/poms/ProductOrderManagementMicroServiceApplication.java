package com.drinkanddelight.poms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProductOrderManagementMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductOrderManagementMicroServiceApplication.class, args);
	}

	

}

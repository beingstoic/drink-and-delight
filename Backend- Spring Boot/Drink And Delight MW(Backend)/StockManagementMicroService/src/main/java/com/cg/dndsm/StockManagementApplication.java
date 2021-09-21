package com.cg.dndsm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("com.cg.dndsm.service")
public class StockManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockManagementApplication.class, args);
	}

}

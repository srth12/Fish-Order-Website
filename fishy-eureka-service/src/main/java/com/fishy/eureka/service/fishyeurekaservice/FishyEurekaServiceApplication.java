package com.fishy.eureka.service.fishyeurekaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class FishyEurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FishyEurekaServiceApplication.class, args);
	}
}

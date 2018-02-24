package com.fish.order.fishorderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class FishOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FishOrderServiceApplication.class, args);
	}
}

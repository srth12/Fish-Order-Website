package com.fishy.dashboard.fishdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FishDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(FishDashboardApplication.class, args);
	}
}

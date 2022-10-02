package com.gateway.gatewayRailwayTicket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GatewayRailwayTicketApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayRailwayTicketApplication.class, args);
	}

}

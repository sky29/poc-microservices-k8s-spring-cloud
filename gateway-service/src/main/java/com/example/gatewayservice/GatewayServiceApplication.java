package com.example.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}

	
	// Below commented lines: in case want to configure programmatic routing

	/*
	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes().build();
	}

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
			.route(p -> p
				.path("/customer")
				.uri("http://localhost:9004"))
			.build();
	}*/

}

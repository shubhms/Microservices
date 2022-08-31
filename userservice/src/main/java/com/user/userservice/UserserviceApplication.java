package com.user.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	// this rest template bean is used in UserController
	// to interact with contact Service to get all the contacts of
	// current userId
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}

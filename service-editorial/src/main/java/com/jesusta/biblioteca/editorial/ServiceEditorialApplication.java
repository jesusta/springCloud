package com.jesusta.biblioteca.editorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ServiceEditorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceEditorialApplication.class, args);
	}

}

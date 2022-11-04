package com.jesusta.biblioteca.libros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ServiceLibrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceLibrosApplication.class, args);
	}

}

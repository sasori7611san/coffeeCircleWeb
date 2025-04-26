package com.example.coffeeCircleWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.example.coffeeCircleWeb.model")
@EnableJpaRepositories(basePackages = "com.example.coffeeCircleWeb.repository")
@SpringBootApplication
@EnableJpaAuditing
public class CoffeeCircleWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeeCircleWebApplication.class, args);
	}

}

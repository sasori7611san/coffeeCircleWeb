package com.example.coffeeCircleWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CoffeeCircleWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeeCircleWebApplication.class, args);
	}

}

package com.example.coffeeCircleWeb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/**")//全エンドポイントに対してCORSを適用
					.allowedOrigins("http://localhost:3000")//フロントエンドのURL
					.allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
					.allowedHeaders("*")
					.allowCredentials(true);
			}
		};
	}
}

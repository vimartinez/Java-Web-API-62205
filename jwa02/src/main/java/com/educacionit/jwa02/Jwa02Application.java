package com.educacionit.jwa02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
public class Jwa02Application {

	public static void main(String[] args) {
		SpringApplication.run(Jwa02Application.class, args);
	}
	
	@Bean
	public OpenAPI customOpenAPI(@Value("V1") String appVersion) {
		return new OpenAPI().info(new Info().title("Java Web API - API Spring Boot - Películas")
				.version(appVersion)
				.description("Java Web API - ejercicio 2")
				.termsOfService("http://google.com")
				.license(new License().name("Apache 2.0").url("http://google.com.ar")));
	}

}

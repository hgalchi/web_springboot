package com.example.WebSpringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = "com.example.WebSpringboot")
@EntityScan(basePackages = "com.example.WebSpringboot")
public class WebSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebSpringbootApplication.class, args);
	}

}

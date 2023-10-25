package com.example.WebSpringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.example.WebSpringboot.part03","com.example.WebSpringboot.part02","com.example.WebSpringboot.part05"})
@EnableJpaAuditing
public class WebSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebSpringbootApplication.class, args);
	}

}
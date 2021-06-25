package com.micasa.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class MicasaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicasaApiApplication.class, args);
	}

}

package com.api.apiFutbol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.api"})
@EntityScan ( basePackages = {"com.api"} )
@EnableJpaRepositories ( basePackages = {"com.api"} )
public class ApiFutbolApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiFutbolApplication.class, args);
	}

}

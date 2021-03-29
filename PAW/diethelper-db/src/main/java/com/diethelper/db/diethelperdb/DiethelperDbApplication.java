package com.diethelper.db.diethelperdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.diethelper.db.diethelperdb.repository")
@SpringBootApplication
public class DiethelperDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiethelperDbApplication.class, args);
	}

}

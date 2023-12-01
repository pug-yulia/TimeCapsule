package com.project.TimeCapsule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.project.TimeCapsule", "com.project.TimeCapsule.security"})
public class TimeCapsuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimeCapsuleApplication.class, args);
	}

}

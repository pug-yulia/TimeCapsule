package com.project.TimeCapsule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.project.TimeCapsule", "com.project.TimeCapsule.security"})
public class TimeCapsuleApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TimeCapsuleApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(TimeCapsuleApplication.class, args);
    }
}

package com.example.spring.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class AopPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopPocApplication.class, args);
	}

}

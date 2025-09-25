package com.example.spring.circular.dependency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CircularDependencyApplication {

	/*
	Basically there are two approach to resolve Circular dependency
	1. use @Lazy Annnotaion that we can use at stter / constructor, filed and bean level
	2. Use @PostConstruct in one of bean Say in Bean A  and remove @Autowired annotation from the bean A  reference
	in Bean B.

	 */

	public static void main(String[] args) {
		SpringApplication.run(CircularDependencyApplication.class, args);
	}

}

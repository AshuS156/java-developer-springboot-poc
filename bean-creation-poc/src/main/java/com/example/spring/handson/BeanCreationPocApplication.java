package com.example.spring.handson;

import com.example.spring.handson.controller.ProductController;
import com.example.spring.handson.repository.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BeanCreationPocApplication {

	public static void main(String[] args) {

		final ConfigurableApplicationContext applicationContext = SpringApplication.run(BeanCreationPocApplication.class,args);
		System.out.println(applicationContext.getBean(ProductController.class));
		System.out.println(applicationContext.getBean(ProductRepository.class));
	}

}

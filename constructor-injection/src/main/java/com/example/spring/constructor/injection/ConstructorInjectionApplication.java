package com.example.spring.constructor.injection;

import com.example.spring.constructor.injection.service.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ConstructorInjectionApplication {

	public static void main(String[] args) {
		final ConfigurableApplicationContext applicationContext = SpringApplication.run(ConstructorInjectionApplication.class,args);
		final User userBean = applicationContext.getBean(User.class);
		userBean.process();
	}

}

package com.example.spring.ecom;

import com.example.spring.ecomassistance.TestExcludeBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
/*@ComponentScan(basePackages = "com.example.spring.*",
		excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = TestExcludeBean.class)

)*/

/*@ComponentScan(basePackages = "com.example.spring.*",
		excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "com.example.spring.ecomassistance.*")

)*/
public class ComponentScanApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComponentScanApplication.class, args);
	}

}

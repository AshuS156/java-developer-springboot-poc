package com.example.spring.ecom.config;

import com.example.spring.ecom.service.CreditCardPayment;
import com.example.spring.ecom.service.DebitCardPayment;
import com.example.spring.ecom.service.PaymentService;
import com.example.spring.ecomassistance.TestExcludeBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "com.example.spring.*",
		excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = TestExcludeBean.class)

)
public class PaymentConfig{

    @Bean
    public PaymentService creditCardPayment() {
        return new CreditCardPayment();
    }

    @Bean
    public PaymentService debitCardpayment() {
        return new DebitCardPayment();
    }
}

package com.vebatekno;


import javax.servlet.FilterRegistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.vebatekno.config.JwtFilter;

@SpringBootApplication
public class ProductAngularJsBootApplication {
	
	@Bean
	public FilterRegistrationBean jwtFilter()
	{
		final FilterRegistrationBean registerationBean = new FilterRegistrationBean();
		
		registerationBean.setFilter(new JwtFilter());
		registerationBean.addUrlPatterns("/rest/*");
		
		return registerationBean;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProductAngularJsBootApplication.class, args);
	}
}

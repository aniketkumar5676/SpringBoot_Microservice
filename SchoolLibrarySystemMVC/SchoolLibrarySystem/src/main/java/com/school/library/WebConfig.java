package com.school.library;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configurable
@ComponentScan(basePackages="com.school.library")
public class WebConfig {

	@Bean
	public InternalResourceViewResolver setSuffix() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setSuffix(".jsp");
		return viewResolver;
		
	}
	
	
}

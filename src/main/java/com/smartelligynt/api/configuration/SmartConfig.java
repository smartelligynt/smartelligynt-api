package com.smartelligynt.api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.smartelligynt.api.interceptor.HttpLogging;
import com.smartelligynt.persist.ESStorage;
import com.smartelligynt.persist.Storage;

@Configuration
public class SmartConfig {
	// @Override
	// public void addInterceptors(InterceptorRegistry registry){
	// System.out.println("$$$4$$$$");
	// registry.addInterceptor(new HttpLogging()).addPathPatterns("/**");
	// }
	@Bean
	public Storage helloWorld() {
		return new ESStorage();
	}
}

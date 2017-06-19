package com.smartelligynt.api.configuration;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.smartelligynt.api.interceptor.HttpLogging;

public class SmartConfig extends WebMvcConfigurerAdapter{
    @Override
    public void addInterceptors(InterceptorRegistry registry){
    	System.out.println("$$$4$$$$");
        registry.addInterceptor(new HttpLogging()).addPathPatterns("/**");
    }
}

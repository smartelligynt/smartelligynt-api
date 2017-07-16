package com.smartelligynt.api.configuration;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.smartelligynt.api.EventRecieverImpl;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {

    	register(EventRecieverImpl.class);
        // scan the resources package for our resources
        //packages(getClass().getPackage().getName() + ".resources");
    }
}
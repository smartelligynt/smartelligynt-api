package com.smartelligynt.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping ("/api")
public class EventReciever {

    @RequestMapping("/")
    public String home() {
        return "Hello!  Smartelligyntians";
    }
    
    @RequestMapping("/events")
    public String events(@RequestBody Events body) {
    	System.out.println("body en = " + body.getEn());
        return "success";
    }

    public static void main(String[] args) {
        SpringApplication.run(EventReciever.class, args);
    }

}

/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.smartelligynt.api;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.smartelligynt.api.model.Device;
import com.smartelligynt.api.model.Event;
import com.smartelligynt.api.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class HelloWorldConfigurationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGreeting() throws Exception {
        ResponseEntity<String> entity = restTemplate
                .getForEntity("http://localhost:" + this.port + "/api/", String.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }
    
    @Test
    public void testEvents() throws Exception {
        Event events = new Event();
        events.setEn("eventname");
        events.setEt("100000");
        events.setEv("eventValue");
        events.setEu("WATTS");
        ResponseEntity<String> entity = 
        		restTemplate.postForEntity("http://localhost:" + this.port + "/api/users/b32f6cec-454c-44e1-971c-f4a38eb5ce9f/devices/aa7c1b06-b243-4f6a-9820-f2e0c12be170/events/", events, String.class);
        
        System.out.println("event saved " + entity.getBody());
        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }
    
    @Test
    public void testDevice() throws Exception {
        Device device = new Device();
        device.setName("A device name");
        device.setType("a device type");
        device.setDesc("a device desc");
        device.setUnit("a device unit");
        
        ResponseEntity<String> entity = 
        		restTemplate.postForEntity("http://localhost:" + this.port + "/api/users/b32f6cec-454c-44e1-971c-f4a38eb5ce9f/devices/aa7c1b06-b243-4f6a-9820-f2e0c12be170", device, String.class);
        
        System.out.println("device saved " + entity.getBody());
        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }
    
    @Test
    public void testDevice2() throws Exception {
        Device device = new Device();
        device.setName("A device name");
        device.setType("a device type");
        device.setDesc("a device desc");
        device.setUnit("a device unit");
        
        ResponseEntity<String> entity = 
        		restTemplate.postForEntity("http://localhost:" + this.port + "/api/users/b32f6cec-454c-44e1-971c-f4a38eb5ce9f/devices/userDefinedDeviceId1", device, String.class);
        
        System.out.println("device2 saved " + entity.getBody());
        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }
    
    
    
    @Test
    public void testUser() throws Exception {
        User user = new User();
        user.setName("a user name");
        
        ResponseEntity<String> entity = 
        		restTemplate.postForEntity("http://localhost:" + this.port + "/api/users", user, String.class);
        
        System.out.println("user saved " + entity.getBody());
        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }
    
   

}

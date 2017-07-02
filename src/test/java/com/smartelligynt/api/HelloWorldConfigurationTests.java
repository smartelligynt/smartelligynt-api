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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.smartelligynt.api.model.Authentication;
import com.smartelligynt.api.model.BaseResponse;
import com.smartelligynt.api.model.Device;
import com.smartelligynt.api.model.Event;
import com.smartelligynt.api.model.Location;
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
    public void testUserWithId() throws Exception {
        User user = new User();
        user.setUserId("b32f6cec-454c-44e1-971c-f4a38eb5ce9f");
        user.setName("a user name");
        user.setEmailId("myemail@gmail.com");
        Location loc = new Location();
        loc.setLongitude("-1.4566");
        loc.setLatitude("0.64885");
        user.setLocation(loc);
        Authentication auth = new Authentication();
        auth.setAppName("wink");
        auth.setAppUserId("winkuserid");
        auth.setCreatedTime(new Date().toString());
        auth.setExpiryTime(new Date().toString());
        auth.setRefreshToken("REF-TOKEN");
        auth.setShortLivedToken("SHORT-TOKEN");
        auth.setLastAccessTime(new Date().toString());
        Authentication auth1 = new Authentication();
        auth1.setAppName("wink1");
        auth1.setAppUserId("winkuserid1");
        auth1.setCreatedTime(new Date().toString());
        auth1.setExpiryTime(new Date().toString());
        auth1.setRefreshToken("REF-TOKEN-1");
        auth1.setShortLivedToken("SHORT-TOKE-1");
        auth1.setLastAccessTime(new Date().toString());
        List<Authentication> lst= new ArrayList<>();
        lst.add(auth);
        lst.add(auth1);
        Map<String, List<Authentication>> mp = new HashMap<>();
        mp.put("wink", lst);
        user.setToken(mp);
        
        ResponseEntity<BaseResponse> entity = 
        		restTemplate.postForEntity("http://localhost:" + this.port + "/api/users/b32f6cec-454c-44e1-971c-f4a38eb5ce9f", user, BaseResponse.class);
        
        System.out.println("user saved " + entity.getBody().getId());
        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }
    
    
    @Test
    public void testEvents() throws Exception {
        Event events = new Event();
        events.setEn("eventname");
        events.setEt("100000");
        events.setEv("eventValue");
        events.setEu("WATTS");
        ResponseEntity<BaseResponse> entity = 
        		restTemplate.postForEntity("http://localhost:" + this.port + "/api/users/b32f6cec-454c-44e1-971c-f4a38eb5ce9f/devices/aa7c1b06-b243-4f6a-9820-f2e0c12be170/events/", events, BaseResponse.class);
        
        System.out.println("event saved " + entity.getBody().getId());
        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }
    
    @Test
    public void testDevice() throws Exception {
        Device device = new Device();
        device.setName("A device name");
        device.setType("a device type");
        device.setDesc("a device desc");
        device.setUnit("a device unit");
        
        ResponseEntity<BaseResponse> entity = 
        		restTemplate.postForEntity("http://localhost:" + this.port + "/api/users/b32f6cec-454c-44e1-971c-f4a38eb5ce9f/devices/aa7c1b06-b243-4f6a-9820-f2e0c12be170", device, BaseResponse.class);
        
        System.out.println("device saved " + entity.getBody().getId());
        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }
    
    @Test
    public void testDevice2() throws Exception {
        Device device = new Device();
        device.setName("A device name");
        device.setType("a device type");
        device.setDesc("a device desc");
        device.setUnit("a device unit");
        
        ResponseEntity<BaseResponse> entity = 
        		restTemplate.postForEntity("http://localhost:" + this.port + "/api/users/b32f6cec-454c-44e1-971c-f4a38eb5ce9f/devices/userDefinedDeviceId1", device, BaseResponse.class);
        
        System.out.println("device2 saved " + entity.getBody().getId());
        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }
    
    
    @Test
    public void testGetDevice() throws Exception {
      
        
        ResponseEntity<Device> entity = 
        		restTemplate.getForEntity("http://localhost:" + this.port + "/api/users/b32f6cec-454c-44e1-971c-f4a38eb5ce9f/devices/aa7c1b06-b243-4f6a-9820-f2e0c12be170", Device.class);
        
        System.out.println("device2 saved " + entity.getBody().getName());
        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }
    
    
    
    @Test
    public void testUser() throws Exception {
        User user = new User();
        user.setName("a user name");
        user.setEmailId("myemail@gmail.com");
        Location loc = new Location();
        loc.setLongitude("-1.4566");
        loc.setLatitude("0.64885");
        user.setLocation(loc);
        Authentication auth = new Authentication();
        auth.setAppName("wink");
        auth.setAppUserId("winkuserid");
        auth.setCreatedTime(new Date().toString());
        auth.setExpiryTime(new Date().toString());
        auth.setRefreshToken("REF-TOKEN");
        auth.setShortLivedToken("SHORT-TOKEN");
        auth.setLastAccessTime(new Date().toString());
        Authentication auth1 = new Authentication();
        auth1.setAppName("wink1");
        auth1.setAppUserId("winkuserid1");
        auth1.setCreatedTime(new Date().toString());
        auth1.setExpiryTime(new Date().toString());
        auth1.setRefreshToken("REF-TOKEN-1");
        auth1.setShortLivedToken("SHORT-TOKE-1");
        auth1.setLastAccessTime(new Date().toString());
        List<Authentication> lst= new ArrayList<>();
        lst.add(auth);
        lst.add(auth1);
        Map<String, List<Authentication>> mp = new HashMap<>();
        mp.put("wink", lst);
        user.setToken(mp);
        
        ResponseEntity<BaseResponse> entity = 
        		restTemplate.postForEntity("http://localhost:" + this.port + "/api/users", user, BaseResponse.class);
        
        System.out.println("user saved " + entity.getBody().getId());
        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }
    
    
    @Test
    public void testGetUser() throws Exception {
        User user = new User();
        user.setName("a user name");
        user.setEmailId("myemail@gmail.com");
        Location loc = new Location();
        loc.setLongitude("-1.4566");
        loc.setLatitude("0.64885");
        user.setLocation(loc);
        Authentication auth = new Authentication();
        auth.setAppName("sthing");
        auth.setAppUserId("sthingid");
        auth.setCreatedTime(new Date().toString());
        auth.setExpiryTime(new Date().toString());
        auth.setRefreshToken("REF-TOKEN");
        auth.setShortLivedToken("SHORT-TOKEN");
        auth.setLastAccessTime(new Date().toString());
        Authentication auth1 = new Authentication();
        auth1.setAppName("sthing");
        auth1.setAppUserId("sthingid");
        auth1.setCreatedTime(new Date().toString());
        auth1.setExpiryTime(new Date().toString());
        auth1.setRefreshToken("REF-TOKEN-1");
        auth1.setShortLivedToken("SHORT-TOKE-1");
        auth1.setLastAccessTime(new Date().toString());
        List<Authentication> lst= new ArrayList<>();
        lst.add(auth);
        lst.add(auth1);
        Map<String, List<Authentication>> mp = new HashMap<>();
        mp.put("sthing", lst);
        user.setToken(mp);
        
        ResponseEntity<BaseResponse> entity = 
        		restTemplate.postForEntity("http://localhost:" + this.port + "/api/users", user, BaseResponse.class);
        
        System.out.println("user saved in getUser test" + entity.getBody().getId());
        System.out.println("Now retrive saved user " + entity.getBody().getId());
        
        System.out.println("http://localhost:" + this.port + "/api/users/" + entity.getBody().getId());
        ResponseEntity<User> userResponse = 
        		restTemplate.getForEntity("http://localhost:" + this.port + "/api/users/" + entity.getBody().getId(),  User.class);
        
        assertEquals(HttpStatus.OK, userResponse.getStatusCode());
        assertEquals(entity.getBody().getId(), userResponse.getBody().getUserId());
    }
    
   

}

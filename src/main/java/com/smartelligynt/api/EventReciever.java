package com.smartelligynt.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.smartelligynt.api.model.BaseResponse;
import com.smartelligynt.api.model.Device;
import com.smartelligynt.api.model.Event;
import com.smartelligynt.api.model.User;

@SpringBootApplication
@RestController
@RequestMapping (value="/api")

//TODO : handle null response from Storage everywhere
public class EventReciever {

    private Storage esStorage = new ESStorage();
	
    //@Autowired
    //@Qualifier("esstorage")
	public void setEventStorageor(Storage eventStorageor) {
		this.esStorage = eventStorageor;
	}

	@RequestMapping("/")
    public String home() {
        return "Hello!  Smartelligyntians !!!!";
    }
	
//	@RequestMapping(value="/users/{userId}/devices/{deviceId}/events", method = RequestMethod.GET)
//    public String getEvents(@PathVariable String deviceId,  @RequestBody Event event) {
//    	String val = esStorage.saveEvent(deviceId, event);
//    	System.out.println("######################################################################################################");
//        return val;
//    }
    
    @RequestMapping(value="/events", method = RequestMethod.POST)
    public String events1(@RequestBody Events body) {
    	System.out.println("body en = " + body.getEn());
        return "success";
    }
    
    @RequestMapping(value="/users/{userId}/devices/{deviceId}/events", method = RequestMethod.POST)
    public BaseResponse events(@PathVariable String deviceId,  @RequestBody Event event) {
    	StorageResponse val = esStorage.saveEvent(deviceId, event);
    	BaseResponse response = new BaseResponse();
    	response.setId(val.get_id());
        return response;
    }
    
    
    @RequestMapping(value="/users/{userId}/devices/{deviceId}", method = RequestMethod.POST)
    public BaseResponse devices(@PathVariable String userId, @PathVariable String deviceId,  @RequestBody Device device) {
    	StorageResponse val = esStorage.saveDevice(userId, deviceId, device);
    	BaseResponse response = new BaseResponse();
    	response.setId(val.get_id());
        return response;
    }

    
    @RequestMapping(value="/users/{userId}/devices/{deviceId}", method = RequestMethod.GET)
    public Device getDevices(@PathVariable String userId, @PathVariable String deviceId) {
    	Device val = esStorage.getDevice(userId, deviceId);
        return val;
    }
    
    @RequestMapping(value="/users", method = RequestMethod.POST)
	public BaseResponse users(@RequestBody User user) throws IOException {
//    	InputStream inputStream  = request.getInputStream();
//    	int ch;
//    	StringBuilder sb = new StringBuilder();
//    	while((ch = inputStream.read()) != -1)
//    	    sb.append((char)ch);
//    	
//    	System.out.println( sb.toString());
    	
    	StorageResponse val = esStorage.saveUser(null, user);
    	BaseResponse response = new BaseResponse();
    	response.setId(val.get_id());
        return response;
    }
    
    @RequestMapping(value="/users/{userId}", method = RequestMethod.POST)
    public BaseResponse users(@PathVariable String userId,  @RequestBody User user) {
    	StorageResponse val = esStorage.saveUser(userId, user);
    	BaseResponse response = new BaseResponse();
    	response.setId(val.get_id());
        return response;
    }

    
//    @RequestMapping(value="/users/{userId}", method = RequestMethod.GET)
//    public User users(@PathVariable String userId) {
//    	GetUserResponse val = esStorage.getUser(userId);
//        return val.getUser();
//    }
    //return all user information & all devices & all chart information
//    @RequestMapping(value="/users/{emailId}", method = RequestMethod.GET)
//    public String usersByEmailId( @PathVariable String emailId,  @RequestBody User user) {
//    	String val = esStorage.saveUser(userId, user);
//    	System.out.println("######################################################################################################");
//        return val;
//    }

    @RequestMapping(value="/users/{userId}", method = RequestMethod.GET)
    public User getUsers(@PathVariable String userId) {
    	User val = esStorage.getUserById(userId);
    	//BaseResponse response = new BaseResponse();
    	//response.setId(val.get_id());
        return val;
    }
    
    public static void main(String[] args) {
        SpringApplication.run(EventReciever.class, args);
    }

}

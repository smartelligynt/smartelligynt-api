package com.smartelligynt.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import com.smartelligynt.client.api.EventReciever;
import com.smartelligynt.client.api.model.BaseResponse;
import com.smartelligynt.client.api.model.Device;
import com.smartelligynt.client.api.model.Event;
import com.smartelligynt.client.api.model.User;
import com.smartelligynt.persist.ESStorage;
import com.smartelligynt.persist.Storage;
import com.smartelligynt.persist.StorageResponse;

@SpringBootApplication
// @RestController

// TODO : handle null response from Storage everywhere
public class EventRecieverImpl implements EventReciever {

	@Autowired
	//@Qualifier("esstorage1")
	private Storage esStorage;// = new ESStorage();

//	public void setEventStorageor(Storage eventStorageor) {
//		this.esStorage = eventStorageor;
//	}

	public String home() {
		return "Hello!  Smartelligyntians !!!!";
	}

	public BaseResponse devices(String userId, String deviceId, Device device) {
		StorageResponse val = esStorage.saveDevice(userId, deviceId, device);
		BaseResponse response = new BaseResponse();
		response.setId(val.get_id());
		return response;
	}

	public Device getDevices(String userId, String deviceId) {
		Device val = esStorage.getDevice(userId, deviceId);
		return val;
	}

	public BaseResponse users(User user) {
		// InputStream inputStream = request.getInputStream();
		// int ch;
		// StringBuilder sb = new StringBuilder();
		// while((ch = inputStream.read()) != -1)
		// sb.append((char)ch);
		//
		// System.out.println( sb.toString());

		StorageResponse val = esStorage.saveUser(null, user);
		BaseResponse response = new BaseResponse();
		response.setId(val.get_id());
		return response;
	}

	public BaseResponse users(String userId, User user) {
		StorageResponse val = esStorage.saveUser(userId, user);
		BaseResponse response = new BaseResponse();
		response.setId(val.get_id());
		return response;
	}

	public User getUsers(String userId) {
		User val = esStorage.getUserById(userId);
		// BaseResponse response = new BaseResponse();
		// response.setId(val.get_id());
		return val;
	}

	public BaseResponse events(String userId, String deviceId, Event event) {
		StorageResponse val = esStorage.saveEvent(deviceId, event);
		BaseResponse response = new BaseResponse();
		response.setId(val.get_id());
		return response;
	}

	public static void main(String[] args) {
		SpringApplication.run(EventRecieverImpl.class, args);
	}

	@Override
	public String events1(Event body) {
		// TODO Auto-generated method stub
		return null;
	}

}

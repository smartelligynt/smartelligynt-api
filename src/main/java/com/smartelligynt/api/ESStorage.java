package com.smartelligynt.api;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.smartelligynt.api.model.Device;
import com.smartelligynt.api.model.Event;
import com.smartelligynt.api.model.User;

@Resource(name="esstorage")
public class ESStorage implements Storage {

	//@Autowired
	public RestTemplate restTemplate = new RestTemplate();
	private String BASE_ES_URL = "https://search-smartelligyntes-zfnjlomb5dgk7gwbziwkvtkglq.us-west-2.es.amazonaws.com/";
	private String EVENT_URL = "events/";
	private String DEVICE_URL = "devices/";
	private String USER_URL = "users/user/";

	public String save(ProcessedEvent event) {
		// TODO Auto-generated method stub
		ResponseEntity<Object> entiry = restTemplate.postForEntity(BASE_ES_URL + EVENT_URL, event, Object.class);
		if (entiry.getStatusCode().is2xxSuccessful()) {
			return "ok";
		}
		return "error";
	}

	@Override
	public String saveEvent(String deviceId, Event event) {
		ResponseEntity<Object> entiry = restTemplate.postForEntity(BASE_ES_URL + EVENT_URL + deviceId, event, Object.class);
		if (entiry.getStatusCode().is2xxSuccessful()) {
			return "ok";
		}
		return "error";
	}

	@Override
	public String saveDevice(String userId, String deviceId, Device device) {
		ResponseEntity<Object> entiry = restTemplate.postForEntity(BASE_ES_URL + DEVICE_URL + userId + "/" + deviceId, device, Object.class);
		if (entiry.getStatusCode().is2xxSuccessful()) {
			return "ok";
		}
		return "error";
	}

	@Override
	public String saveUser(String userId, User user) {
		if (userId == null || userId.isEmpty())
		{
			userId = UUID.randomUUID().toString();
		}
		ResponseEntity<Object> entiry = restTemplate.postForEntity(BASE_ES_URL + USER_URL + "/" + userId, user, Object.class);
		if (entiry.getStatusCode().is2xxSuccessful()) {
			return "ok";
		}
		return "error";
	}

}

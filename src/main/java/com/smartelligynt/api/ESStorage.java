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

	public StorageResponse save(ProcessedEvent event) {
		// TODO Auto-generated method stub
		ResponseEntity<StorageResponse> entiry = restTemplate.postForEntity(BASE_ES_URL + EVENT_URL, event, StorageResponse.class);
		if (entiry.getStatusCode().is2xxSuccessful()) {
			return entiry.getBody();
		}
		return null;
	}

	@Override
	public StorageResponse saveEvent(String deviceId, Event event) {
		ResponseEntity<StorageResponse> entiry = restTemplate.postForEntity(BASE_ES_URL + EVENT_URL + deviceId, event, StorageResponse.class);
		if (entiry.getStatusCode().is2xxSuccessful()) {
			return entiry.getBody();
		}
		return null;
	}

	@Override
	public StorageResponse saveDevice(String userId, String deviceId, Device device) {
		ResponseEntity<StorageResponse> entiry = restTemplate.postForEntity(BASE_ES_URL + DEVICE_URL + userId + "/" + deviceId, device, StorageResponse.class);
		if (entiry.getStatusCode().is2xxSuccessful()) {
			return entiry.getBody();
		}
		return null;
	}

	@Override
	public StorageResponse saveUser(String userId, User user) {
		
		if (userId == null || userId.isEmpty())
		{
			userId = UUID.randomUUID().toString();
			user.setUserId(userId);

		}
		ResponseEntity<StorageResponse> entiry = restTemplate.postForEntity(BASE_ES_URL + USER_URL  + userId, user, StorageResponse.class);
		
		if (entiry.getStatusCode().is2xxSuccessful()) {
			return entiry.getBody();
		}
		return null;
	}

}

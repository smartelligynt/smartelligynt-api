package com.smartelligynt.persist;

import java.util.UUID;


//import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.smartelligynt.client.api.model.Device;
import com.smartelligynt.client.api.model.Event;
import com.smartelligynt.client.api.model.User;

@Component
public class ESStorage implements Storage {

	
	//@Autowired
	public RestTemplate restTemplate = new RestTemplate();
	private String BASE_ES_URL = "https://search-smartelligyntes-zfnjlomb5dgk7gwbziwkvtkglq.us-west-2.es.amazonaws.com/";
	private String EVENT_URL = "events/";
	private String DEVICE_URL = "devices/";
	private String USER_URL = "users/user/";

//	public StorageResponse save(ProcessedEvent event) {
//		// TODO Auto-generated method stub
//		ResponseEntity<StorageResponse> entiry = restTemplate.postForEntity(BASE_ES_URL + EVENT_URL, event, StorageResponse.class);
//		if (entiry.getStatusCode().is2xxSuccessful()) {
//			return entiry.getBody();
//		}
//		return null;
//	}

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
	
	@Override
	public User getUserById(String userId) {
		
		if (userId == null || userId.isEmpty())
		{
			return null;

		}
		
		ResponseEntity<User> entiry = restTemplate.getForEntity(BASE_ES_URL + USER_URL  + userId + "/_source",  User.class);
		
		if (entiry.getStatusCode().is2xxSuccessful()) {
			return entiry.getBody();
		}
		return null;
	}

	@Override
	public Device getDevice(String userId, String deviceId) {
		if (userId == null || userId.isEmpty() || deviceId == null || deviceId.isEmpty())
		{
			return null;

		}
		
		ResponseEntity<Device> entiry = restTemplate.getForEntity(BASE_ES_URL + DEVICE_URL  + userId + "/" + deviceId + "/_source",  Device.class);
		
		if (entiry.getStatusCode().is2xxSuccessful()) {
			return entiry.getBody();
		}
		return null;
	}

	@Override
	public GetUserResponse getUser(String userId) {

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		
		if (userId == null || userId.isEmpty())
		{
			return null;
		}
		ResponseEntity<GetUserResponse> entiry = restTemplate.getForEntity(BASE_ES_URL + USER_URL  + userId, GetUserResponse.class);
		return entiry.getBody();
	}
}

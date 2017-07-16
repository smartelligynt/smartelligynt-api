package com.smartelligynt.persist;


import com.smartelligynt.client.api.model.Device;
import com.smartelligynt.client.api.model.Event;
import com.smartelligynt.client.api.model.User;

public interface Storage {
	
	public StorageResponse saveEvent(String deviceId, Event event);
	public StorageResponse saveDevice(String userId, String deviceId, Device device);
	public StorageResponse saveUser(String userId, User user);
	public User getUserById(String userId);
	public Device getDevice(String userId, String deviceId);
	public GetUserResponse getUser(String userId);

}

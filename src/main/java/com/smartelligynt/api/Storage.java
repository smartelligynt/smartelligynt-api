package com.smartelligynt.api;

import com.smartelligynt.api.model.Device;
import com.smartelligynt.api.model.Event;
import com.smartelligynt.api.model.User;

public interface Storage {
	
	public StorageResponse saveEvent(String deviceId, Event event);
	public StorageResponse saveDevice(String userId, String deviceId, Device device);
	public StorageResponse saveUser(String userId, User user);
	public GetUserResponse getUser(String userId);

}

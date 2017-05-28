package com.smartelligynt.api;

import com.smartelligynt.api.model.Device;
import com.smartelligynt.api.model.Event;
import com.smartelligynt.api.model.User;

public interface Storage {
	
	public  String saveEvent(String deviceId, Event event);
	public  String saveDevice(String userId, String deviceId, Device device);
	public String saveUser(String userId, User user);

}

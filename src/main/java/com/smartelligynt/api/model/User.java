package com.smartelligynt.api.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
	
	private String userId;
	private String emailId;
	private String name;
	private String timeZone;
	private Location location; //address long lat home address billing address
	
	//key app name
	private Map <String,List<Authentication>> tokens = new HashMap<>();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ClassPojo [name = " + name + "]";
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Map<String, List<Authentication>> getToken() {
		return tokens;
	}

	public void setToken(Map<String, List<Authentication>> token) {
		this.tokens = token;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}


}



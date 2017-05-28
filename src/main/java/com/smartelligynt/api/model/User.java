package com.smartelligynt.api.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
	
	private String emailId;
	private String name;
	private String timeZone;
	private String location; //address long lat home address billing address
	
	//key app name
	private Map <String,List<Authentication>> token = new HashMap<>();
	private String app;

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
}


class Authentication
{
	String appName;
	String shortLivedToken;
	String refreshToken;
	String createdTime;
	String expiryTime;
	String lastAccessTime;
	String appUserId;
	
}
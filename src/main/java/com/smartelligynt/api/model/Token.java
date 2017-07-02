package com.smartelligynt.api.model;

import java.util.Date;

public class Token {
	private String value;
	private Date expiresOn;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Date getExpiresOn() {
		return expiresOn;
	}
	public void setExpiresOn(Date expiresOn) {
		this.expiresOn = expiresOn;
	}
}

package com.smartelligynt.api.model;

import java.util.Date;

public class Authentication
{
	String appName;
	Token shortLivedToken;
	Token refreshToken;
	Date createdTime;
	// TODO not needed anymore, validity moved to token data type
	Date expiryTime;
	Date lastAccessTime;
	String appUserId;
	
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public Token getShortLivedToken() {
		return shortLivedToken;
	}
	public void setShortLivedToken(Token shortLivedToken) {
		this.shortLivedToken = shortLivedToken;
	}
	public Token getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(Token refreshToken) {
		this.refreshToken = refreshToken;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getExpiryTime() {
		return expiryTime;
	}
	public void setExpiryTime(Date expiryTime) {
		this.expiryTime = expiryTime;
	}
	public Date getLastAccessTime() {
		return lastAccessTime;
	}
	public void setLastAccessTime(Date lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}
	public String getAppUserId() {
		return appUserId;
	}
	public void setAppUserId(String appUserId) {
		this.appUserId = appUserId;
	}
	
}

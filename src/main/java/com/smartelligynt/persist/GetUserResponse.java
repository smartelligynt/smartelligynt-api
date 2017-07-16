package com.smartelligynt.persist;

import com.smartelligynt.client.api.model.User;

/**
 * 
 * @author spattan { "_id": "b32f6cec-454c-44e1-971c-f4a38eb5ce9f", "_index":
 *         "users", "_source": { DOCUMENT }, "_type": "user", "_version": 8,
 *         "found": true }
 *
 */
public class GetUserResponse extends GetResponse<User> {
	public User getUser() {
		return super.get_source();
	}
	public void setUser(User user) {
		super.set_source(user);
	}
	
}

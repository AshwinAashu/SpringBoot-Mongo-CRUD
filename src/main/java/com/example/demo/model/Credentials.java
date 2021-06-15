package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.data.mongodb.core.mapping.Field;

@Document("credential")
public class Credentials {
	@Id
	public String id;
	public String username;

	public String password;
	
	
	
	public Credentials(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	//empty constructor
	public Credentials() {
		
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}


	

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}


	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	
	@Override
	public String toString() {
		return String.format("user[id='%s',username='%s', password='%s']", id, username, password);
	}
	
}

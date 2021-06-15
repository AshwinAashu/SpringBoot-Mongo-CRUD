package com.example.demo.services;

import java.util.List;

import com.example.demo.model.Credentials;

public interface CredentialServiceImptl {
	List<Credentials> getAll();

	Credentials create(String Username, String Password);

	Credentials findByUsername(String Username);
	Credentials update(String Username, String Password);
	void deleteByUsername(String Username);
	void deleteALL();
}

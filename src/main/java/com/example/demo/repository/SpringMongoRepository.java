package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Credentials;

@Repository
public interface SpringMongoRepository extends MongoRepository<Credentials, String> {
	public Credentials findByUsername(String username);
	public List<Credentials> findAll();
}

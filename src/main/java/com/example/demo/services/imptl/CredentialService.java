package com.example.demo.services.imptl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Credentials;
import com.example.demo.repository.SpringMongoRepository;
import com.example.demo.services.CredentialServiceImptl;
import com.mongodb.DuplicateKeyException;


@Service
public class CredentialService implements CredentialServiceImptl{
	@Autowired
	private SpringMongoRepository credRepo;
	

//	@Override
//	public List<Credentials> getcredRepoByUsername(String username){
//			
//			return credRepo.findByUsername(username);
//		}  
	
	@Override 
	public Credentials create(String Username, String Password) {
		try {
			return credRepo.save(new Credentials(Username, Password));
		}  catch (DuplicateKeyException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}


	@Override
	public List<Credentials> getAll() {
		// TODO Auto-generated method stub
		return credRepo.findAll();
	}
	

	@Override
	public Credentials findByUsername(String Username) {
		return credRepo.findByUsername(Username);
	}

	@Override
	public Credentials update(String Username, String Password) {
		Credentials temp =  credRepo.findByUsername(Username);
		
		temp.setPassword(Password);
		return credRepo.save(temp);
	}
	
	@Override
	public void deleteByUsername(String Username) {
		Credentials temp = credRepo.findByUsername(Username);
		credRepo.delete(temp);
	}
	
	@Override
	public void deleteALL() {
		credRepo.deleteAll();
	}
	
}

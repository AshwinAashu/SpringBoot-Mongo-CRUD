package com.example.demo.controller;



import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Credentials;
import com.example.demo.services.CredentialServiceImptl;

@RestController
@RequestMapping("api/")
public class CredentialController {
	@Autowired
	private CredentialServiceImptl CredentialService;
	
	//get  all the users
	@GetMapping("credential")
	public List<Credentials> getAll(){
		return CredentialService.getAll();
	}
	
	
	//get credentials by username
	@RequestMapping(method=RequestMethod.GET, value="credential/{username}")
	public Credentials getByUsername(@RequestParam("username") String username){
		
		return CredentialService.findByUsername(username);
	}
	
	
	//create new users 
	@RequestMapping(method=RequestMethod.POST, value="credential/createUser", consumes =  APPLICATION_JSON_VALUE, produces =  APPLICATION_JSON_VALUE)
	public ResponseEntity<Credentials> createCredentials(@RequestBody Credentials user){
		
		Credentials obj = CredentialService.create(user.getUsername(), user.getPassword());
	       if(obj==null){
	    	   return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
	       }
	       else{
	    	   return ResponseEntity.status(HttpStatus.CREATED).body(obj);
	       }
	}
	
	//Update the user password 
	@RequestMapping(method= RequestMethod.PUT, value="credential/update", consumes= APPLICATION_JSON_VALUE , produces= APPLICATION_JSON_VALUE)
	public Credentials updateCredentials(@RequestBody Credentials obj) {
		return CredentialService.update(obj.getUsername(), obj.getPassword());
	}

	//Delete a single user
	@RequestMapping(method=RequestMethod.DELETE, value="credential/delete")
	public String deleteByUsername(@RequestParam("username") String username) {
		CredentialService.deleteByUsername(username);
		return "deleted"+username;
	}
	
	//Delete All users
	@RequestMapping(method=RequestMethod.DELETE , value="credential/deleteAll")
	public String deleteALL() {
		CredentialService.deleteALL();
		return "all users have been deleted";
	}
	
	
}

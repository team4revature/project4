package com.revature.Project2.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.Project2.beans.User;
import com.revature.Project2.service.UserService;

@RestController
public class UserCtrl {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable int id) {
		
		return userService.getUser(id);
		
	}
	
	@PostMapping("/createUser")
	public ResponseEntity<User> createUser(@RequestBody User user){
		
		user = userService.createUser(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
}

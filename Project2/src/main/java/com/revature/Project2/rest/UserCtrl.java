package com.revature.Project2.rest;

import javax.servlet.http.HttpSession;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.Project2.beans.User;
import com.revature.Project2.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserCtrl {

	@Autowired
	private UserService userService;

	@GetMapping("/user/{id}")
	public User getUser(@PathVariable int id) {

		return userService.getUser(id);

	}

	@GetMapping("/userName/{userName}")
	public User getUser(@PathVariable String userName) {
		return userService.getUserByName(userName);
	}

	@PostMapping("/createUser")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		user = userService.createUser(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody User user) {

		user = userService.validateUser(user);

		if (user == null) {

			return new ResponseEntity<User>(user, HttpStatus.UNAUTHORIZED);
		}

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<User> register(@RequestBody User user) {
		
		user = userService.createUser(user);
		
		if(user == null) {
			return new ResponseEntity<User>(user, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {

		return userService.getAllUsers();

	}

}

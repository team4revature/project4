package com.revature.Project2.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.revature.Project2.security.Token;
import com.revature.Project2.security.TokenAuthenticationService;
import com.revature.Project2.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserCtrl {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpServletRequest req;
	
	@Autowired
	private HttpServletResponse res;
	
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable int id) {
		
		return userService.getUser(id);
	}
	
	@PostMapping("/createUser")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		user = userService.createUser(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<Token> login(@RequestBody User user) {
		user = userService.validateUser(user);
		
		if(user == null) {
			System.out.println("User not found or validated");
			return new ResponseEntity<Token>(new Token(), HttpStatus.NOT_FOUND);
		}
		
		TokenAuthenticationService.addAuthentication(res, user.getUsername());
		Token token = new Token(res.getHeader(TokenAuthenticationService.HEADER_STRING));
		System.out.println(res.getHeader("Authentication"));
		return new ResponseEntity<Token>(token, HttpStatus.OK);
	}
}

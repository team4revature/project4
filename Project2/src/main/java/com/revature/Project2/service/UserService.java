package com.revature.Project2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.Project2.beans.User;
import com.revature.Project2.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	public User getUser(int id) {
		
		
		//TODO do not send back regular user object with password: replace with custom DTO
		return userRepo.findOne(id);
	}
	
	public User createUser(User user) {
		
		return userRepo.save(user);
	}
	
}

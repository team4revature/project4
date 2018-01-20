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
		
		System.out.println("REMOVE user service get");
		
		return userRepo.findOne(id);
	}
	
	public User createUser(User user) {
		
		System.out.println("REMOVE user service create");
		
		return userRepo.save(user);
	}
	
}

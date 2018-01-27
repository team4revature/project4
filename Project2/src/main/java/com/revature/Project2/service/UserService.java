package com.revature.Project2.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.Project2.beans.User;
import com.revature.Project2.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
//	@Autowired
//	private HttpSession session;
	
	public User getUser(int id) {
		//TODO do not send back regular user object with password: replace with custom DTO
		return userRepo.findOne(id);
	}
	
	public User getUserByName(String userName) {
		
		return userRepo.findUserByUsername(userName);
		
	}
	public User createUser(User user) {
		
		return userRepo.save(user);
	}
	
	public User validateUser(User user, HttpSession session) {
		System.out.println("in validateUser");
		User retrievedUser = userRepo.findUserByUsername(user.getUsername());
		System.out.println("Retrieved user: " + retrievedUser);
		if(retrievedUser == null || !retrievedUser.getPassword().equals(user.getPassword())) {
			System.out.println("null or passwords don't match");
			return null;
		}
		session.setAttribute("user", retrievedUser);
		System.out.println("session is currently " + session.getId());
		return retrievedUser;
	}
}

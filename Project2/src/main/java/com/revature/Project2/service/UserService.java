package com.revature.Project2.service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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
		
		if(userRepo.findUserByUsername(user.getUsername()) == null) {
			return userRepo.save(user);
		}
		else {
			return null;
		}
	}
	
	public User validateUser(User user) {
		System.out.println("in validateUser");
		User retrievedUser = userRepo.findUserByUsername(user.getUsername());

		if(retrievedUser == null || !retrievedUser.getPassword().equals(user.getPassword())) {
			System.out.println("null or passwords don't match");
			return null;
		}
		return retrievedUser;
	}
	
	public List<User> getAllUsers() {
		ArrayList<User> l = new ArrayList<>();
		l = (ArrayList<User>) userRepo.findAll();
		return l;		
	}
}

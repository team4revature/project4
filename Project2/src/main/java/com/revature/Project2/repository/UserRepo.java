package com.revature.Project2.repository;

import org.springframework.data.repository.CrudRepository;

import com.revature.Project2.beans.User;

public interface UserRepo extends CrudRepository<User, Integer> {
	User findUserByUsername(String name);
}

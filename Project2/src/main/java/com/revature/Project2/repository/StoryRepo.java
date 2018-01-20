package com.revature.Project2.repository;

import org.springframework.data.repository.CrudRepository;

import com.revature.Project2.beans.Story;

public interface StoryRepo extends CrudRepository<Story, Integer>{

}

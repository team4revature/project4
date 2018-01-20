package com.revature.Project2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.Project2.beans.Story;
import com.revature.Project2.repository.StoryRepo;

@Service
public class StoryService {
	
	@Autowired
	StoryRepo storyRepo;
	
	public Story getStory(int id) {
		
		return storyRepo.findOne(id);
		
	}
	
	public Story createStory(Story story) {
		
		return storyRepo.save(story);
	}
	
	
}

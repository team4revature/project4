package com.revature.Project2.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.Project2.beans.Story;
import com.revature.Project2.service.StoryService;

@RestController
public class StoryCtrl {
	
	@Autowired
	StoryService storyService;
	
	@GetMapping("/story/{id}")
	public Story getStory(@PathVariable int id) {
		
		System.out.println("REMOVE BEFORE PUSHING service story get");
		return storyService.getStory(id);
	}
	
	@PostMapping("/createStory")
	public ResponseEntity<Story> createStory(@RequestBody Story story) {
		
		System.out.println("REMOVE BEFORE PUSHING service story post");
		story = storyService.createStory(story);
		return new ResponseEntity<Story>(story, HttpStatus.CREATED);
	}
	
}

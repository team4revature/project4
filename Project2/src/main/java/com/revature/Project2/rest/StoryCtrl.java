package com.revature.Project2.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.Project2.beans.Story;
import com.revature.Project2.beans.Task;
import com.revature.Project2.dto.DeleteDTO;
import com.revature.Project2.dto.TaskDTO;
import com.revature.Project2.service.StoryService;

@RestController
@CrossOrigin(origins = "*")
public class StoryCtrl {
	
	@Autowired
	StoryService storyService;
	
	@GetMapping("/story/{id}")
	public Story getStory(@PathVariable int id) {
		
		return storyService.getStory(id);
	}
	
	@PostMapping("/story/addtask")
	public ResponseEntity<Task> createSwimlane(@RequestBody TaskDTO dto) {
		return new ResponseEntity<Task>(storyService.addTask(dto), HttpStatus.CREATED);
	}
	
	@PostMapping("/story/removetask")
	public ResponseEntity removeTask(@RequestBody DeleteDTO dto) {
		storyService.removeTask(dto);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@PostMapping("/story/delete")
	public ResponseEntity deleteSwimlane(@RequestBody Story story) {
		storyService.deleteStory(story);
		return new ResponseEntity(HttpStatus.OK);
	}
}

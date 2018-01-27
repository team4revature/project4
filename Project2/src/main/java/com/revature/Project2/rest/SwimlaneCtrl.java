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

import com.revature.Project2.beans.Swimlane;
import com.revature.Project2.dto.StoryDTO;
import com.revature.Project2.service.SwimlaneService;

@RestController
@CrossOrigin(origins = "*")
public class SwimlaneCtrl {
	
	@Autowired
	SwimlaneService swimService;
	
	@GetMapping("/swimlane/{id}")
	public Swimlane getSwimlane(@PathVariable int id) {
		
		return swimService.getSwimlane(id);
	}
	
	@PostMapping("/swimlane/addstory")
	public ResponseEntity<Swimlane> addStory(@RequestBody StoryDTO story) {
		Swimlane swimlane = swimService.addStory(story);
		return new ResponseEntity<Swimlane>(swimlane, HttpStatus.CREATED);
	}
	
	@PostMapping("/swimlane/delete")
	public ResponseEntity deleteSwimlane(@RequestBody int swimlaneId) {
		swimService.deleteSwimlane(swimlaneId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

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
		//System.out.println("Hello");
		return swimService.getSwimlane(id);
	}
	
	@PostMapping("/swimlane/addstory")
	public ResponseEntity<Story> addStory(@RequestBody StoryDTO dto) {
		Story story = swimService.addStory(dto);
		return new ResponseEntity<Story>(story, HttpStatus.CREATED);
	}
	
	@PostMapping("/swimlane/delete")
	public ResponseEntity deleteSwimlane(@RequestBody Swimlane swimlane) {
		swimService.deleteSwimlane(swimlane);
		return new ResponseEntity(HttpStatus.OK);
	}
}

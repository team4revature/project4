package com.revature.Project2.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.Project2.beans.Swimlane;
import com.revature.Project2.service.SwimlaneService;

@RestController
public class SwimlaneCtrl {
	
	@Autowired
	SwimlaneService swimService;
	
	@GetMapping("/swimlane/{id}")
	public Swimlane getSwimlane(@PathVariable int id) {
		
		System.out.println("REMOVE BEFORE PUSH swimlane control get");
		
		return swimService.getSwimlane(id);
	}
	
	@PostMapping("/createSwimlane")
	public ResponseEntity<Swimlane> createSwimlane(@RequestBody Swimlane swim){
		
		System.out.println("REMOVE BEFORE PUSH swimlane control post");
		swim = swimService.createSwimlane(swim);
		return new ResponseEntity<Swimlane>(swim, HttpStatus.CREATED);
		
	}
	
}

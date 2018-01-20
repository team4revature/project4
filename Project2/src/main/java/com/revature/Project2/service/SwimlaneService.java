package com.revature.Project2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.Project2.beans.Swimlane;
import com.revature.Project2.repository.SwimlaneRepo;

@Service
public class SwimlaneService {
	
	@Autowired
	SwimlaneRepo swimRepo;
	
	public Swimlane getSwimlane(int id) {
		
		System.out.println("REMOVE BEFORE PUSH service get swimlane");
		return swimRepo.findOne(id);
	}
	
	public Swimlane createSwimlane(Swimlane swim) {
		
		System.out.println("REMOVE BEFORE PUSH service create swimlane");
		return swimRepo.save(swim);
	}
	
}

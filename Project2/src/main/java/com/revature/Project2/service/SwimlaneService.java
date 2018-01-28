package com.revature.Project2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.Project2.beans.Board;
import com.revature.Project2.beans.Story;
import com.revature.Project2.beans.Swimlane;
import com.revature.Project2.dto.DeleteDTO;
import com.revature.Project2.dto.StoryDTO;
import com.revature.Project2.repository.BoardRepo;
import com.revature.Project2.repository.SwimlaneRepo;

@Service
public class SwimlaneService {
	
	@Autowired
	SwimlaneRepo swimRepo;
	
	@Autowired
	BoardRepo boardRepo;
	
	public Swimlane getSwimlane(int id) {
		
		return swimRepo.findOne(id);
	}
	
	public Swimlane createSwimlane(Swimlane swim) {
		
		return swimRepo.save(swim);
	}
	
	public Story addStory(StoryDTO story) {
		
		Swimlane swimlane = swimRepo.findOne(story.getSwimlaneId());
		swimlane.getStories().add(story.getStory());
		swimlane = swimRepo.save(swimlane);
		return swimlane.getStories().get(swimlane.getStories().size() - 1);
	}
	
	public boolean removeStory(DeleteDTO dto) {
		Swimlane swimlane = swimRepo.findOne(dto.getObjectId());
		swimlane.getStories().remove(dto.getIndex());
		swimRepo.save(swimlane);
	
		return true;
	}
	
	public boolean deleteSwimlane(DeleteDTO dto) {
		Board board = boardRepo.findOne(dto.getObjectId());
		board.getSwimlanes().remove(dto.getIndex());
		boardRepo.save(board);
	
		return true;
	}
}

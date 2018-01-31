package com.revature.Project2.service;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.Project2.beans.Board;
import com.revature.Project2.beans.History;
import com.revature.Project2.beans.Story;
import com.revature.Project2.beans.Swimlane;
import com.revature.Project2.dto.DeleteDTO;
import com.revature.Project2.dto.StoryDTO;
import com.revature.Project2.repository.BoardRepo;
import com.revature.Project2.repository.HistoryRepo;
import com.revature.Project2.repository.SwimlaneRepo;

@Service
public class SwimlaneService {
	
	@Autowired
	SwimlaneRepo swimRepo;
	
	@Autowired
	BoardRepo boardRepo;
	
	@Autowired
	HistoryRepo histRepo;
	
	@Autowired
	HistoryService histServ;
	
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
		
		System.out.println("removing story");
		//David Graves
		
		//System.out.println("history is now " + histRepo.findHistoryByBid(swimlane.getBid()));
		
//		history = histRepo.findHistoryByBid(swimlane.getBid());
//		history.sort(Comparator.comparing(History::getHid));
		
//		System.out.println("history " + history);
//			if(history.get(history.size() - 1).getValue() != //if the last two values are not equal to previous minus last
//					(history.get(history.size() - 2).getValue() -
//					(swimlane.getStories().get(dto.getIndex()).getDifficulty()))) {
//				if(history.get(history.size() - 2).getValue() != //if the next to last are not equal to previous minus last
//						(history.get(history.size() - 3).getValue() -
//						(swimlane.getStories().get(dto.getIndex()).getDifficulty()))) {
//					//then delete next to last
//					histRepo.delete(history.get(history.size() - 2));
//					System.out.println("history if " + history);
//				}
//				else {
//					//otherwise delete last
//					histRepo.delete(history.get(history.size() - 1));
//					System.out.println("history else" + history);
//				}
//			}
		
//		List<History> history = board.getBurnDown();
//		board.getBurnDown().sort(Comparator.comparing(History::getKey));
//		History lastIndex = history.get(history.size() - 1);
//		board.getBurnDown().add(new History(new Date(), 
//				((board.getBurnDown().get(board.getBurnDown().size() - 1)).getValue() - 
//				(swimlane.getStories().get(dto.getIndex()).getDifficulty())), 
//				(board.getBurnDown().get(board.getBurnDown().size() - 1)).getBid()));
		//histRepo.save(newHist);
		
		swimlane.getStories().remove(dto.getIndex());
		swimRepo.save(swimlane);
	
		return true;
	}
	
	public Swimlane updateSwimlane(Swimlane swimlane) {
		return swimRepo.save(swimlane);
	}
	
	public List<Swimlane> updateSwimlanes(List<Swimlane> swimlanes) {
		for(Swimlane lane : swimlanes) {
			swimRepo.save(lane);
		}
		return swimlanes;
	}
	
	public boolean deleteSwimlane(DeleteDTO dto) {
		Board board = boardRepo.findOne(dto.getObjectId());
		board.getSwimlanes().remove(dto.getIndex());
		boardRepo.save(board);
	
		return true;
	}
}

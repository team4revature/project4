package com.revature.Project2.rest;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.Project2.beans.History;
import com.revature.Project2.beans.Story;
import com.revature.Project2.beans.Swimlane;
import com.revature.Project2.dto.DeleteDTO;
import com.revature.Project2.dto.StoryDTO;
import com.revature.Project2.service.HistoryService;
import com.revature.Project2.service.SwimlaneService;

@RestController
@CrossOrigin(origins = "*")
public class SwimlaneCtrl {
	
	@Autowired
	SwimlaneService swimService;
	
	@Autowired
	HistoryService histService;
	
	private boolean canExecute = true;
	
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
	
	@PostMapping("/swimlane/removestory")
	public ResponseEntity removeStory(@RequestBody DeleteDTO dto) {
		
		//added functionality of history for burndown
		Swimlane swimlane = swimService.getSwimlane(dto.getObjectId());
		int difficulty = (swimlane.getStories().get(dto.getIndex()).getDifficulty());
		if(canExecute) {
			this.updateHistory(swimlane, difficulty);
		}
		
		swimService.removeStory(dto);
		this.canExecute = true;
		return new ResponseEntity(HttpStatus.OK);
	}
	
	private void updateHistory(Swimlane swimlane, int difficulty) {
		System.out.println("apparently I can execute");
		this.canExecute = false;
		List <History> history = histService.getHistoryByBid(swimlane.getBid());
		history.sort(Comparator.comparing(History::getHid));
		int value = history.get(history.size() - 1).getValue();
		History hist = new History(new Date(),( value - difficulty), swimlane.getBid());
		histService.createHistory(hist);
		
	}
	
	@PostMapping("/swimlane/update")
	public ResponseEntity<Swimlane> updateSwimlane(@RequestBody Swimlane swimlane) {
		return new ResponseEntity<Swimlane>(swimService.updateSwimlane(swimlane), HttpStatus.OK);
	}
	
	@PostMapping("/swimlane/updateAll")
	public ResponseEntity<List<Swimlane>> updateSwimlanes(@RequestBody List<Swimlane> swimlanes) {
		return new ResponseEntity<List<Swimlane>>(swimService.updateSwimlanes(swimlanes), HttpStatus.OK);
	}
	
	@PostMapping("/swimlane/delete")
	public ResponseEntity deleteSwimlane(@RequestBody DeleteDTO dto) {
		swimService.deleteSwimlane(dto);
		return new ResponseEntity(HttpStatus.OK);
	}
}

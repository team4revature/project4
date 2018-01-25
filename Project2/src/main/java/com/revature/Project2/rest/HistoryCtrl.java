package com.revature.Project2.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.Project2.beans.History;
import com.revature.Project2.dto.HistoryDto;
import com.revature.Project2.service.HistoryService;

@RestController
public class HistoryCtrl {
	
	@Autowired
	HistoryService historyService;
	
	@GetMapping("/history/{id}")
	public HistoryDto getHistory(@PathVariable int id) {
		
		return historyService.getHistory(id);
	}
	
	@PostMapping("/createHistory")
	public History createHistory(@RequestBody History history) {
		
		history = historyService.createBoard(history);
		return history;
		
	}
	
}

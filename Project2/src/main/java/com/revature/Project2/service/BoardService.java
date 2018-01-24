package com.revature.Project2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.Project2.beans.Board;
import com.revature.Project2.beans.Swimlane;
import com.revature.Project2.repository.BoardRepo;

@Service
public class BoardService {
	
	@Autowired
	BoardRepo boardRepo;
	
	public Board getBoard(int id) {
		
		return boardRepo.findOne(id);
	}
	
	public Board createBoard(Board board) {
		
		return boardRepo.save(board);
	}
	
	public Board addSwimlane(int id, Swimlane swimlane) {
		
		Board board = boardRepo.findOne(id);
		board.getSwimlanes().add(swimlane);
		return boardRepo.save(board);
	}
}

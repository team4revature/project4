package com.revature.Project2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.Project2.beans.Board;
import com.revature.Project2.repository.BoardRepo;

@Service
public class BoardService {
	
	@Autowired
	BoardRepo boardRepo;
	
	public Board getBoard(int id) {
		
		System.out.println("REMOVE BEFORE PUSH board service get");
		return boardRepo.findOne(id);
	}
	
	public Board createBoard(Board board) {
		
		System.out.println("REMOVE BEFORE PUSH board service create");
		return boardRepo.save(board);
	}
}

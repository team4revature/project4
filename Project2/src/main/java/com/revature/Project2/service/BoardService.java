package com.revature.Project2.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.Project2.beans.Board;
import com.revature.Project2.beans.History;
import com.revature.Project2.beans.User;


import com.revature.Project2.beans.Swimlane;
import com.revature.Project2.dto.SwimlaneDTO;
import com.revature.Project2.repository.BoardRepo;
import com.revature.Project2.repository.SwimlaneRepo;

@Service
public class BoardService {
	
	@Autowired
	BoardRepo boardRepo;
	
	@Autowired 
	HttpSession session;
	
	@Autowired
	SwimlaneRepo swimRepo;

	public Board getBoard(int id) {
		
		
		return boardRepo.findOne(id);
	}
	
	public Board createBoard(Board board) {
		
		return boardRepo.save(board);
	}
	

	public List<History> getBurndown(int id) {
		
//		User user = (User)session.getAttribute("user");
//		System.out.println(user.getUid() + "");
//		
		
		return boardRepo.findOne(id).getBurnDown();
	}

	public Board addSwimlane(SwimlaneDTO dto) {
		Board board = boardRepo.findOne(dto.getBoardId());
		board.getSwimlanes().add(dto.getSwimlane());
		return boardRepo.save(board);
	}

	public List<Swimlane> updateSwimlanes(Board board) {
		//Board myBoard = boardRepo.findOne(board.getBid());
		//swimRepo.delete(myBoard.getSwimlanes());
		//myBoard.setSwimlanes(board.getSwimlanes());
		return boardRepo.save(board).getSwimlanes();
	}
	
	public List<History> updateHistory(Board board){
		return boardRepo.save(board).getBurnDown();
	}
}

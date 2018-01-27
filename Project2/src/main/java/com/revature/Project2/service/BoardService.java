package com.revature.Project2.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.Project2.beans.Board;
import com.revature.Project2.beans.History;
import com.revature.Project2.beans.User;
import com.revature.Project2.repository.BoardRepo;

@Service
public class BoardService {
	
	@Autowired
	BoardRepo boardRepo;
	
	@Autowired 
	HttpSession session;
	
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
}

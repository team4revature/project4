package com.revature.Project2.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.Project2.beans.Board;
import com.revature.Project2.beans.History;
import com.revature.Project2.beans.User;


import com.revature.Project2.beans.Swimlane;
import com.revature.Project2.dto.AddUserDTO;
import com.revature.Project2.dto.SwimlaneDTO;
import com.revature.Project2.repository.BoardRepo;
import com.revature.Project2.repository.SwimlaneRepo;
import com.revature.Project2.repository.UserRepo;

@Service
public class BoardService {
	
	@Autowired
	BoardRepo boardRepo;
	
	@Autowired 
	HttpSession session;
	
	@Autowired
	UserRepo userRepo;
	
	public ArrayList<Board> getAllMasterBoards(int id){
		ArrayList<Board> ab = new ArrayList<Board>();
		ArrayList<Board> ret = new ArrayList<Board>();
		ab=(ArrayList<Board>) boardRepo.findAll();
		for(int i = 0;i< ab.size();i++) {
			if(ab.get(i).getScrumMaster().getUid()== id) {
				ret.add(ab.get(i));
			}
		}
		return ret;
	}
	
	public ArrayList<Board> getAllMemberBoards(int id){
		ArrayList<Board> ab = new ArrayList<Board>();
		ArrayList<Board> ret = new ArrayList<Board>();
		//List<Board> b = (List<Board>) boardRepo.findAll();
		ab=(ArrayList<Board>) boardRepo.findAll();
		for(int i = 0;i< ab.size();i++) {
			for(int j = 0; j< ab.get(i).getScrumTeam().size();j++) {
				if(ab.get(i).getScrumTeam().get(j).getUid() ==id) {
					ret.add(ab.get(i));
				}
			}
		}
		return ret;
	}

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

	public void addUsers(AddUserDTO dto) {
		Board board = boardRepo.findOne(dto.getBid());
		board.getScrumTeam().add(userRepo.findOne(dto.getUid()));
		boardRepo.save(board);
	}
	
	public Board addSwimlane(SwimlaneDTO dto) {
		Board board = boardRepo.findOne(dto.getBoardId());
		dto.getSwimlane().setBid(dto.getBoardId()); // see if it works here
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

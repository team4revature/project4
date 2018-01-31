package com.revature.Project2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.Project2.beans.Board;
import com.revature.Project2.beans.Swimlane;
import com.revature.Project2.beans.User;
import com.revature.Project2.dto.SwimlaneDTO;
import com.revature.Project2.repository.BoardRepo;
import com.revature.Project2.repository.SwimlaneRepo;
import com.revature.Project2.repository.UserRepo;

@Service
public class BoardService {
	
	@Autowired
	BoardRepo boardRepo;
	@Autowired 
	UserRepo userRepo;
	public List<Board> getAllMasterBoards(int id){
		User u = userRepo.findOne(id);
		return (List<Board>) u.getBoards();
	}
	
	public ArrayList<Board> getAllMemberBoards(int id){
		ArrayList<Board> ab = new ArrayList<Board>();
		ArrayList<Board> ret = new ArrayList<Board>();
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
}

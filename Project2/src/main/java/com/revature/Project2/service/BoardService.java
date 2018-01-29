package com.revature.Project2.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.Project2.beans.Board;
import com.revature.Project2.dto.SwimlaneDTO;
import com.revature.Project2.repository.BoardRepo;

@Service
public class BoardService {
	
	@Autowired
	BoardRepo boardRepo;
	
	public ArrayList<Board> getAllMasterBoards(int id){
		ArrayList<Board> ab = new ArrayList<Board>();
		ArrayList<Board> ret = new ArrayList<Board>();
		ab=(ArrayList<Board>) boardRepo.findAll();
		for(int i = 0;i< ab.size();i++) {
			if(ab.get(i).getScrumMaster().getUid() == id) {
				ret.add(ab.get(i));
			}
		}
		return ret;
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
	public Board getBoard(int id) {
		boardRepo.findAll();
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
}

package com.revature.Project2.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.Project2.beans.Board;
import com.revature.Project2.beans.Story;
import com.revature.Project2.dto.SwimlaneDTO;
import com.revature.Project2.service.BoardService;

@RestController
//requestmapping board
@CrossOrigin(origins = "*")
public class BoardCtrl {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board/{id}")
	public Board getBoard(@PathVariable int id) {
		Board board = boardService.getBoard(id);
		for(Story s : board.getSwimlanes().get(0).getStories()) {
			System.out.println(s);
		}
		return board;
	}
	
	@PostMapping("/createBoard")
	public ResponseEntity<Board> createBoard(@RequestBody Board board) {
		
		board = boardService.createBoard(board);
		return new ResponseEntity<Board>(board, HttpStatus.CREATED);
	}
	
	@PostMapping("/board/addswimlane")
	public ResponseEntity<Board> createSwimlane(@RequestBody SwimlaneDTO dto) {
		System.out.println("in add swimlane");
		return new ResponseEntity<Board>(boardService.addSwimlane(dto), HttpStatus.CREATED);
	}
}

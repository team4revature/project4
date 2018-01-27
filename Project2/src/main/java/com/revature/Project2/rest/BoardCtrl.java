package com.revature.Project2.rest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

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
import com.revature.Project2.beans.History;
import com.revature.Project2.dto.HistoryDto;
import com.revature.Project2.service.BoardService;

@RestController
@CrossOrigin(origins = "*")
public class BoardCtrl {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board/{id}")
	public Board getBoard(@PathVariable int id) {
		
		return boardService.getBoard(id);
	}
	
	@PostMapping("/createBoard")
	public ResponseEntity<Board> createBoard(@RequestBody Board board){
		
		board = boardService.createBoard(board);
		return new ResponseEntity<Board>(board, HttpStatus.CREATED);
	}
	
	@GetMapping("/burndown/{id}")
	public List<HistoryDto> getBurndownByBoardId(@PathVariable int id, HttpSession session) {
		
		System.out.println("session is now " + session.getId());
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
		
		List<History> history = boardService.getBurndown(id);
		List<HistoryDto> burndown = new ArrayList<>();
		
		for(History h : history) {
			burndown.add(new HistoryDto(h.getHid(), sf.format(h.getKey()), h.getValue() ));
		}
		System.out.println("hit burndown");
		return burndown;
	}
	
}

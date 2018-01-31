package com.revature.Project2.rest;

import java.util.ArrayList;
import java.util.List;

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
import com.revature.Project2.beans.Swimlane;
import com.revature.Project2.beans.User;
import com.revature.Project2.dto.AddUserDTO;
import com.revature.Project2.dto.SwimlaneDTO;
import com.revature.Project2.service.BoardService;
import com.revature.Project2.service.UserService;

@RestController
//requestmapping board
@CrossOrigin(origins = "*")
public class BoardCtrl {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/board/{id}")
	public Board getBoard(@PathVariable int id) {
		Board board = boardService.getBoard(id);
	
		return board;
	}
	
	@GetMapping("/getboards/{id}")
	public List<Board> getBoards(@PathVariable int id) {
		User userd = userService.getUser(id);
		return userd.getBoards();
	}
	
	@GetMapping("/getMasterBoards/{id}")
	public List<Board> getMasterBoards(@PathVariable int id) {
		ArrayList<Board> boards = boardService.getAllMasterBoards(id);
		return boards;
	}
	
	@GetMapping("/getMemberBoards/{id}")
	public List<Board> getAssBoards(@PathVariable int id) {
		ArrayList<Board> boards = boardService.getAllMemberBoards(id);
		return boards;
	}
	
	@PostMapping("/createBoard")
	public ResponseEntity<Board> createBoard(@RequestBody Board board){
		boardService.createBoard(board);
		User u = userService.getUser(board.getScrumMaster().getUid());
		u.getBoards().add(board);
		userService.createUser(u);	
		
		return new ResponseEntity<Board>(board, HttpStatus.CREATED);
	}
	
	@PostMapping("/updateBoard")
	public ResponseEntity saveBoard(@RequestBody AddUserDTO dto) {
		System.out.println(dto.getBid() +" " + dto.getUid());
		boardService.addUsers(dto);
		
		return new ResponseEntity(HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/board/addswimlane")
	public ResponseEntity<Board> createSwimlane(@RequestBody SwimlaneDTO dto) {
		return new ResponseEntity<Board>(boardService.addSwimlane(dto), HttpStatus.CREATED);
	}
	
	@PostMapping("/board/updateswimlanes")
	public ResponseEntity<List<Swimlane>> updateSwimlanes(@RequestBody Board board) {
		return new ResponseEntity<List<Swimlane>>(boardService.updateSwimlanes(board), HttpStatus.OK);
	}
}

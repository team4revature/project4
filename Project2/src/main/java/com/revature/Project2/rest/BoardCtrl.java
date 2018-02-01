package com.revature.Project2.rest;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

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
import com.revature.Project2.beans.History;
import com.revature.Project2.dto.HistoryDto;
import com.revature.Project2.beans.Story;
import com.revature.Project2.dto.SwimlaneDTO;
import com.revature.Project2.beans.User;
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
        User u = userService.getUser(id);
        List<Board> b = new ArrayList<Board>();
        for (int i = 0; i < u.getBoards().size(); i++) {
            if (u.getBoards().get(i).getScrumMaster().getUid() == id) {
                b.add(u.getBoards().get(i));
            }
        }
        return b;
    }

    @GetMapping("/getMemberBoards/{id}")
    public List<Board> getAssBoards(@PathVariable int id) {
       /* User u = userService.getUser(id);
        List<Board> b = new ArrayList<Board>();
        b=boardService.
        for (int i = 0; i < u.getBoards().size(); i++) {
            for (int j = 0; i < u.getBoards().get(i).getScrumTeam().size(); j++) {
                if (u.getBoards().get(i).getScrumTeam().get(j).getUid() == id) {
                    b.add(u.getBoards().get(i));

                }
            }
        }*/
        return boardService.getAllMemberBoards(id);
    }
	
	@PostMapping("/createBoard")
	public ResponseEntity<Board> createBoard(@RequestBody Board board){
		System.out.println("in create board");
		boardService.createBoard(board);
		User u = userService.getUser(board.getScrumMaster().getUid());
		u.getBoards().add(board);
		userService.createUser(u);	
		
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
	

	@PostMapping("/updateBoard")
	public ResponseEntity saveBoard(@RequestBody AddUserDTO dto) {
		boardService.addUsers(dto);
		
		return new ResponseEntity(HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/board/addswimlane") //COME BACK HERE--------------------------------------------
	public ResponseEntity<Board> createSwimlane(@RequestBody SwimlaneDTO dto) {
		return new ResponseEntity<Board>(boardService.addSwimlane(dto), HttpStatus.CREATED);
	}
	
	@PostMapping("/board/updateswimlanes")
	public ResponseEntity<List<Swimlane>> updateSwimlanes(@RequestBody Board board) {
		return new ResponseEntity<List<Swimlane>>(boardService.updateSwimlanes(board), HttpStatus.OK);
	}
	
	@PostMapping("/board/updateburndown")
	public ResponseEntity<List<History>> updateBurnDown(@RequestBody Board board ) {
		return new ResponseEntity<List<History>>(boardService.updateHistory(board), HttpStatus.OK);
	}
}

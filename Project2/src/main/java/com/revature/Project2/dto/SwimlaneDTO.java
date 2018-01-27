package com.revature.Project2.dto;

import com.revature.Project2.beans.Swimlane;

public class SwimlaneDTO {
	private int boardId;
	Swimlane swimlane;
	
	public SwimlaneDTO() { }
	
	public SwimlaneDTO(int boardId, Swimlane swimlane) {
		super();
		this.boardId = boardId;
		this.swimlane = swimlane;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public Swimlane getSwimlane() {
		return swimlane;
	}

	public void setSwimlane(Swimlane swimlane) {
		this.swimlane = swimlane;
	}
}

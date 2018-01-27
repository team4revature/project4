package com.revature.Project2.dto;

import com.revature.Project2.beans.Story;

public class StoryDTO {
	private int swimlaneId;
	private Story story;
	
	public StoryDTO() { }

	public StoryDTO(int swimlaneId, Story story) {
		super();
		this.swimlaneId = swimlaneId;
		this.story = story;
	}

	public Story getStory() {
		return story;
	}

	public void setStory(Story story) {
		this.story = story;
	}

	@Override
	public String toString() {
		return "StoryDTO [swimlaneId=" + swimlaneId + ", story=" + story + "]";
	}


	public int getSwimlaneId() {
		return swimlaneId;
	}

	public void setSwimlaneId(int swimlaneId) {
		this.swimlaneId = swimlaneId;
	}
}

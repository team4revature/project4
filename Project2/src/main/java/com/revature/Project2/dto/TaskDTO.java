package com.revature.Project2.dto;

import com.revature.Project2.beans.Task;

public class TaskDTO {
	private int storyId;
	private Task task;
	
	public TaskDTO() { }

	public TaskDTO(int storyId, Task task) {
		super();
		this.storyId = storyId;
		this.task = task;
	}

	public int getStoryId() {
		return storyId;
	}

	public void setStoryId(int storyId) {
		this.storyId = storyId;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	@Override
	public String toString() {
		return "TaskDTO [storyId=" + storyId + ", task=" + task + "]";
	}
}

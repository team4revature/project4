package com.revature.Project2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.Project2.beans.Task;
import com.revature.Project2.repository.TaskRepo;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepo taskRepo;
	
	public Task getTask(int taskId) {
			
		return taskRepo.findOne(taskId);
		
	}
	
	public Task updateTask(Task task) {
		return taskRepo.save(task);
	}
	
	public boolean deleteTask(Task task) {
		taskRepo.delete(task.getTid());
		return true;
	}
	
}

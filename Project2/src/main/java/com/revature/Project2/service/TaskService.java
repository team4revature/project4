package com.revature.Project2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.Project2.beans.Task;
import com.revature.Project2.repository.TaskRepo;

@Service
public class TaskService {
	
	@Autowired
	TaskRepo taskRepo;
	
	public Task getTask(int taskId) {
		
		System.out.println("REMOVE BEFORE PUSH - get task");	
		return taskRepo.findOne(taskId);
		
	}
	
	public Task createTask(Task task) {
		
		System.out.println("REMOVE BEFORE PUSH - create task");
		taskRepo.save(task);
		
		return task;
	}
	
}

package com.revature.Project2.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.Project2.beans.Task;
import com.revature.Project2.service.TaskService;

@RestController
public class TaskCtrl {

	@Autowired
	TaskService taskService;
	
	@GetMapping("/task/{id}")
	public Task getTask(@PathVariable int id) {
		
		System.out.println("REMOVE BEFORE PUSH - get task");
		return taskService.getTask(id);
	}
	
	@PostMapping("/createTask")
	public ResponseEntity<Task> createTask(@RequestBody Task task){

		System.out.println("REMOVE BEFORE PUSH - create task");
		task = taskService.createTask(task);
		return new ResponseEntity<Task>(task, HttpStatus.CREATED);
	}
}

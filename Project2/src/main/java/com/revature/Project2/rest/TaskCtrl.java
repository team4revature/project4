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

import com.revature.Project2.beans.Task;
import com.revature.Project2.dto.TaskDTO;
import com.revature.Project2.service.TaskService;

@RestController
@CrossOrigin(origins = "*")
public class TaskCtrl {

	@Autowired
	TaskService taskService;
	
	@GetMapping("/task/{id}")
	public Task getTask(@PathVariable int id) {
		
		return taskService.getTask(id);
	}
	
	@PostMapping("/task/update")
	public ResponseEntity<Task> updateTask(@RequestBody Task task) {
		return new ResponseEntity<Task>(taskService.updateTask(task), HttpStatus.OK);
	}
	
	@PostMapping("/task/delete")
	public ResponseEntity deleteTask(@RequestBody Task task) {
		taskService.deleteTask(task);
		return new ResponseEntity(HttpStatus.OK);
	}
}

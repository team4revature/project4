package com.revature.Project2.repository;

import org.springframework.data.repository.CrudRepository;

import com.revature.Project2.beans.Task;

public interface TaskRepo extends CrudRepository<Task, Integer>{

}

package com.revature.Project2.repository;

import org.springframework.data.repository.CrudRepository;

import com.revature.Project2.beans.Board;

public interface BoardRepo extends CrudRepository<Board, Integer>{

}

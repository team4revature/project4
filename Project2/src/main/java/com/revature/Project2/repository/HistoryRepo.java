package com.revature.Project2.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.revature.Project2.beans.History;

public interface HistoryRepo extends CrudRepository<History, Integer> {
	public List<History> findHistoryByBid(int bid);
}

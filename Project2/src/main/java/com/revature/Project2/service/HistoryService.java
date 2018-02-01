package com.revature.Project2.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.Project2.beans.History;
import com.revature.Project2.dto.HistoryDto;
import com.revature.Project2.repository.HistoryRepo;

@Service
public class HistoryService {
	
	
	@Autowired
	HistoryRepo historyRepo;
	
	public HistoryDto getHistory(int id) {

		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
		
		History history = historyRepo.findOne(id);
		HistoryDto dto = new HistoryDto(history.getHid(), sf.format(history.getKey()), history.getValue());
		return dto;

	}
	
	public List<History> getHistoryByBid(int bid){
		return historyRepo.findHistoryByBid(bid);
	}
	
	public History createHistory(History history) {
		history.setKey(new Date());
		history = historyRepo.save(history);
//		System.out.println("" + history.getKey());
//		System.out.println("" + sf.format(history.getKey()));
//		history.setKey(sf.format(history.getKey()));
//		System.out.println("" + history.getKey());
		return history;
	}
	
}

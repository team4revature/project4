package com.revature.Project2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.Project2.beans.Board;
import com.revature.Project2.beans.Story;
import com.revature.Project2.beans.Task;
import com.revature.Project2.dto.DeleteDTO;
import com.revature.Project2.dto.TaskDTO;
import com.revature.Project2.repository.StoryRepo;

@Service
public class StoryService {
	
	@Autowired
	StoryRepo storyRepo;
	
	public Story getStory(int id) {
		
		return storyRepo.findOne(id);
		
	}
	
	public Story createStory(Story story) {
		
		return storyRepo.save(story);
	}
	
	public Task addTask(TaskDTO dto) {
		System.out.println(dto);
		Story story = storyRepo.findOne(dto.getStoryId());
		story.getTasks().add(dto.getTask());
		story = storyRepo.save(story);
		System.out.println(story.getTasks().get(story.getTasks().size() - 1));
		return story.getTasks().get(story.getTasks().size() - 1);
	}
	
	public boolean removeTask(DeleteDTO dto) {
		Story story = storyRepo.findOne(dto.getObjectId());
		story.getTasks().remove(dto.getIndex());
		storyRepo.save(story);
	
		return true;
	}
	
	public boolean deleteStory(Story story) {
		System.out.println(story);
		System.out.println(storyRepo.exists(story.getStId()));
		storyRepo.delete(story.getStId());
		return true;
	}
}

package com.revature.Project2.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SCRUM_STORY")
public class Story {

	@Id
	@Column(name = "ST_ID")
	@SequenceGenerator(sequenceName = "STORY_SEQ", name = "STORY_SEQ")
	@GeneratedValue(generator = "STORY_SEQ", strategy = GenerationType.SEQUENCE)
	private int stId;

	@Column(name = "STORY_NAME")
	private String storyName;

	@Column(name = "DIFFICULTY")
	private int difficulty;

	// user working on this story
	// @ManyToOne(fetch=FetchType.EAGER)
	// @JoinColumn(name="U_ID")
	// private User user;

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public String getStoryName() {
		return storyName;
	}

	public void setStoryName(String storyName) {
		this.storyName = storyName;
	}

	// @ManyToOne(fetch=FetchType.EAGER)
	// @JoinColumn(name="B_ID")
	// private Swimlane
	//
	// tasks associated with this story
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "ST_ID")
	@OrderColumn
	private List<Task> tasks;

	public int getStId() {
		return stId;
	}

	public void setStId(int stId) {
		this.stId = stId;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Story(int stId, String storyName, List<Task> tasks) {
		super();
		this.stId = stId;
		this.storyName = storyName;
		this.tasks = tasks;
	}

	public Story(String storyName, List<Task> tasks) {
		super();
		this.storyName = storyName;
		// this.stId = stId;
		// this.user = user;
		this.tasks = tasks;
	}

	public Story() {
		super();
	}

	@Override
	public String toString() {
		return "Story [stId=" + stId + ", storyName=" + storyName + ", difficulty=" + difficulty + ", tasks=" + tasks
				+ "]";
	}

}

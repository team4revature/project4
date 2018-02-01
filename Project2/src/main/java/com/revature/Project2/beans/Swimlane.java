package com.revature.Project2.beans;

import java.util.ArrayList;
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
@Table(name="SCRUM_SWIMLANE")
public class Swimlane {
	
	@Id
	@Column(name="S_ID")
	@SequenceGenerator(sequenceName="SLANE_SEQ", name="SLANE_SEQ")
	@GeneratedValue(generator="SLANE_SEQ", strategy=GenerationType.SEQUENCE)
	private int sid;
	
	
	@Column(name="SWIMLANE_NAME")
	private String swimlaneName;
	
	//Stories list
	@OneToMany(fetch=FetchType.EAGER,
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	@JoinColumn(name="S_ID")
	@OrderColumn
	private List<Story> stories;
	
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSwimlaneName() {
		return swimlaneName;
	}

	public void setSwimlaneName(String name) {
		this.swimlaneName = name;
	}

	public List<Story> getStories() {
		return stories;
	}

	public void setStories(List<Story> stories) {
		this.stories = stories;
	}
	/*
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}*/

	public Swimlane(int sid, String name, List<Story> stories) {
		super();
		this.sid = sid;
		this.swimlaneName = name;
		this.stories = stories;
//		this.board = board;
	}
	
	public Swimlane(String name, List<Story> stories) {
		super();
//		this.sid = sid;
		this.swimlaneName = name;
		this.stories = stories;
//		this.board = board;
	}
	
	public Swimlane(String name) {
		this.swimlaneName = name;
		this.stories = new ArrayList<Story>();
	}
	
	public Swimlane() {
		super();
	}

	@Override
	public String toString() {
		return "Swimlane [sid=" + sid + ", swimlaneName=" + swimlaneName + ", stories=" + stories + "]";
	}

}

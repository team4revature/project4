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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	private List<Story> stories;
	
	//boards this swimlane belongs to
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="B_ID")
	private Board board;

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

//	public Board getBoard() {
//		return board;
//	}
//
//	public void setBoard(Board board) {
//		this.board = board;
//	}

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
	
	public Swimlane() {
		super();
	}
	
}

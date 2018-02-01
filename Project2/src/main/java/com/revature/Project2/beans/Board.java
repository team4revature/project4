package com.revature.Project2.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="SCRUM_BOARD")

public class Board implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="B_ID")
	@SequenceGenerator(sequenceName="BOARD_SEQ", name="BOARD_SEQ")
	@GeneratedValue(generator="BOARD_SEQ", strategy=GenerationType.SEQUENCE)
	private int bid;

	@Column(name="BOARD_NAME", unique=true)
	private String boardName;

	//swimlanes
	@OneToMany(fetch=FetchType.EAGER,
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	@JoinColumn(name="B_ID")
	@OrderColumn
	@Fetch(FetchMode.SELECT)
	private List<Swimlane> swimlanes;

	@JsonIgnoreProperties ( { "boards"} )
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="SCRUM_MASTER")
	private User scrumMaster;
	
	@JsonIgnoreProperties ( { "boards"} )
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="SCRUM_PRODUCT_OWNER")
	private User scrumProductOwner;
	
	//list of all team members

	@JsonIgnoreProperties({"boards"})
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="TEAM_MEMBER",
			joinColumns= @JoinColumn(name="BOARD_ID"),
			inverseJoinColumns= @JoinColumn(name="USER_ID"))
	private List<User> scrumTeam;
	
	//map for the burndown chart

	//@LazyCollection(LazyCollectionOption.FALSE)

	@OneToMany(fetch=FetchType.LAZY,
			cascade = CascadeType.ALL)
	@JoinColumn(name = "bid")
	private List<History> burnDown;
	
	public Board() {
		super();
	}
	
	public Board(int bid, String boardName, List<Swimlane> swimlanes, User scrumMaster, User scrumProductOwner, List<User> scrumTeam,
			List<History> burnDown) {
		super();
		this.bid = bid;
		this.boardName = boardName;
		this.swimlanes = swimlanes;
		this.scrumMaster = scrumMaster;
		this.scrumProductOwner = scrumProductOwner;
		this.scrumTeam = scrumTeam;
		this.burnDown = burnDown;
	}

	public Board(String boardName, List<Swimlane> swimlanes, User scrumMaster, User scrumProductOwner, List<User> scrumTeam,
			Map<Date, Integer> burnDown) {
		super();
		this.boardName = boardName;
		this.swimlanes = swimlanes;
		this.scrumMaster = scrumMaster;
		this.scrumProductOwner = scrumProductOwner;
		this.scrumTeam = scrumTeam;
	}


	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}
	
	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public User getScrumMaster() {
		return scrumMaster;
	}

	public void setScrumMaster(User scrumMaster) {
		this.scrumMaster = scrumMaster;
	}

	public List<Swimlane> getSwimlanes() {
		return swimlanes;
	}

	public void setSwimlanes(List<Swimlane> swimlanes) {
		this.swimlanes = swimlanes;
	}

	public User getScrumProductOwner() {
		return scrumProductOwner;
	}

	public void setScrumProductOwner(User scrumProductOwner) {
		this.scrumProductOwner = scrumProductOwner;
	}

	public List<User> getScrumTeam() {
		return scrumTeam;
	}

	public void setScrumTeam(List<User> scrumTeam) {
		this.scrumTeam = scrumTeam;
	}
	
	public List<History> getBurnDown() {
		return burnDown;
	}

	public void setBurnDown(List<History> burnDown) {
		this.burnDown = burnDown;
	}

	
	@Override
	public String toString() {
		return "Board [bid=" + bid + ", boardName=" + boardName + ", swimlanes=" + swimlanes + ", scrumMaster="
				+ scrumMaster + ", scrumProductOwner=" + scrumProductOwner + ", scrumTeam=" + scrumTeam + ", burnDown="
				+ burnDown + "]";
	}
}

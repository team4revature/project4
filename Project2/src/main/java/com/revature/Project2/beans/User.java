package com.revature.Project2.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="SCRUM_USER")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="U_ID")
	@SequenceGenerator(sequenceName="USER_SEQ", name="USER_SEQ")
	@GeneratedValue(generator="USER_SEQ", strategy=GenerationType.SEQUENCE)
	private int uid;
	
	@Column(name="USERNAME", unique = true)
	private String username;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;

	@Column(name="EMAIL", unique = true)
	private String email;
	
	//list of all boards the user contributes to
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "TEAM_MEMBER", 
	joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "U_ID"), 
	inverseJoinColumns = @JoinColumn(name = "BOARD_ID", 
	referencedColumnName = "B_ID"))
	private List<Board> boards;

	public int getUid() {
		return uid;
	}
	
	public User(int uid, String username, String password, String firstName, String lastName, 
			List<Board> boards, String email) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.boards = boards;
		this.email = email;
	}
	
	public User(String username, String password, String firstName, String lastName, 
			List<Board> boards, String email) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.boards = boards;
		this.email = email;
	}
	
	public User() {
		super();
	}
	
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public List<Board> getBoards() {
		return boards;
	}
	
	public void setBoards(List<Board> boards) {
		this.boards = boards;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", boards=" + boards + "]";
	}
}

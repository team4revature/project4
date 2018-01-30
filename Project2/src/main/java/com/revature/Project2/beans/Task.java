package com.revature.Project2.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="SCRUM_TASK")
public class Task {
	
	@Id
	@Column(name="T_ID")
	@SequenceGenerator(sequenceName="TASK_SEQ", name="TASK_SEQ")
	@GeneratedValue(generator="TASK_SEQ", strategy=GenerationType.SEQUENCE)
	private int tid;

	@Column(name="TASK_DESC")
	private String taskDesc;
	
	@Column(name="COMPLETED")
	private boolean completed;

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTaskDesc() {
		return taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public Task(int tid, String taskDesc, boolean completed) {
		super();
		this.tid = tid;
		this.taskDesc = taskDesc;
		this.completed = completed;
	}
	
	public Task(String taskDesc, boolean completed) {
		super();
		this.taskDesc = taskDesc;
		this.completed = completed;
	}
	
	public Task() {
		super();
	}

	@Override
	public String toString() {
		return "Task [tid=" + tid + ", taskDesc=" + taskDesc + ", completed=" + completed + "]";
	}
	
}

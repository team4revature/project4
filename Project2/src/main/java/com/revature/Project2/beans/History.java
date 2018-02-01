package com.revature.Project2.beans;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="SCRUM_HISTORY")
public class History implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="H_ID")
	@SequenceGenerator(sequenceName="HISTORY_SEQ", name="HISTORY_SEQ")
	@GeneratedValue(generator="HISTORY_SEQ", strategy=GenerationType.SEQUENCE)
	private int hid;
	
	@Column(name="KEY")
	private Date key;
	
	@Column(name="VALUE")
	private int value;
	
	private int bid;

	public int getHid() {
		return hid;
	}

	public void setHid(int hid) {
		this.hid = hid;
	}

	public Date getKey() {
		return key;
	}
	
	public void setKey(Date key) {
		this.key=key;
	}

	public void setKey(String key) {
		try {
			this.key = new SimpleDateFormat("yyyy-MM-dd", Locale.US).parse(key);
			System.out.println(key + " parsed as " + this.key);
		}
		catch(ParseException e) {
			e.printStackTrace();
			this.key = new Date();
		}
		
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public History(int hid, String key, int value) {
		super();
		this.hid = hid;
		try {
			this.key = new SimpleDateFormat("yyyy-MM-dd", Locale.US).parse(key);
		}
		catch(ParseException e) {
			e.printStackTrace();
			this.key = new Date();
		}
		this.value = value;
	}
	
	public History( Date key, int value) {
		super();
		this.key = key;
		this.value = value;	
	}
	
	public History(Date key, int value, int bid) {
		super();
		this.key = key;
		this.value = value;
		this.bid = bid;
	}	

	public History() { }

	@Override
	public String toString() {
		return "History [hid=" + hid + ", key=" + key + ", value=" + value + "]";
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}
	
	
}
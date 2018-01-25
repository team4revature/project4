package com.revature.Project2.dto;

import java.io.Serializable;

public class HistoryDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int hid;
	private String key;
	private int value;
	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public HistoryDto(int hid, String key, int value) {
		super();
		this.hid = hid;
		this.key = key;
		this.value = value;
	}
	public HistoryDto() {
		super();
	}
	@Override
	public String toString() {
		return "HistoryDto [hid=" + hid + ", key=" + key + ", value=" + value + "]";
	}
	
	
	
	
}

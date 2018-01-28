package com.revature.Project2.dto;

public class DeleteDTO {
	private int objectId;
	private int index;
	
	DeleteDTO() { }

	public DeleteDTO(int objectId, int index) {
		super();
		this.objectId = objectId;
		this.index = index;
	}

	public int getObjectId() {
		return objectId;
	}

	public void setObjectId(int objectId) {
		this.objectId = objectId;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public String toString() {
		return "DeleteDTO [objectId=" + objectId + ", index=" + index + "]";
	}
}

package com.ctrip.Model;

public class Task {
	private int id;
	private String taskName;
	private String description;
	private int status;
	private int projectId;
	private int developerId;
	private int testerId;
	private int combinedAdjustingOwner;
	private String combinedAdjustingTime;
	private int createUserID;
	private int updateUserID;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public int getDeveloperId() {
		return developerId;
	}
	public void setDeveloperId(int developerId) {
		this.developerId = developerId;
	}
	public int getTesterId() {
		return testerId;
	}
	public void setTesterId(int testerId) {
		this.testerId = testerId;
	}
	public int getCombinedAdjustingOwner() {
		return combinedAdjustingOwner;
	}
	public void setCombinedAdjustingOwner(int combinedAdjustingOwner) {
		this.combinedAdjustingOwner = combinedAdjustingOwner;
	}
	public String getCombinedAdjustingTime() {
		return combinedAdjustingTime;
	}
	public void setCombinedAdjustingTime(String combinedAdjustingTime) {
		this.combinedAdjustingTime = combinedAdjustingTime;
	}
	public int getCreateUserID() {
		return createUserID;
	}
	public void setCreateUserID(int createUserID) {
		this.createUserID = createUserID;
	}
	public int getUpdateUserID() {
		return updateUserID;
	}
	public void setUpdateUserID(int updateUserID) {
		this.updateUserID = updateUserID;
	}

}

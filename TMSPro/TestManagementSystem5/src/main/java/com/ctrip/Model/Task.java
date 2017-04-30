package com.ctrip.Model;

public class Task {
	private int id;
	private String taskName;
	private String description;
	private String status;
	private int projectId;
	private int developerId;
	private int testerId;
	private int combinedAdjustingOwner;
	private String combinedAdjustingTime;
	private int createUserID;
	private int updateUserID;
	
	private String projectName;
	private String developer;
	private String tester;
	private String groupName;
	private String comAdjustingOwner;
	private String createUser;
	private String updateUser;
	
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
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
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getDeveloper() {
		return developer;
	}
	public void setDeveloper(String developer) {
		this.developer = developer;
	}
	public String getTester() {
		return tester;
	}
	public void setTester(String tester) {
		this.tester = tester;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getComAdjustingOwner() {
		return comAdjustingOwner;
	}
	public void setComAdjustingOwner(String comAdjustingOwner) {
		this.comAdjustingOwner = comAdjustingOwner;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

}

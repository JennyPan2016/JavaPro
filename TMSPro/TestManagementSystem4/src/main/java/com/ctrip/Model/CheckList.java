package com.ctrip.Model;

public class CheckList {
	public int id;
	public int taskID;
	public int CRID;
	public String deliverTime;
	public String deliverVersion;
	public String UATClog;
	public String DBRedis;
	public String BUDependence;
	public String bugCheck;
	public String branchCheck;
	public String devStatus;
	public String testStatus;
	public String remark;
	
	public String taskName;
	public String groupName;
	public String projectName;
	public int devStatusId;
	public int testStatId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTaskID() {
		return taskID;
	}
	public void setTaskID(int taskID) {
		this.taskID = taskID;
	}
	public int getCRID() {
		return CRID;
	}
	public void setCRID(int cRID) {
		CRID = cRID;
	}
	public String getDeliverTime() {
		return deliverTime;
	}
	public void setDeliverTime(String deliverTime) {
		this.deliverTime = deliverTime;
	}
	public String getDeliverVersion() {
		return deliverVersion;
	}
	public void setDeliverVersion(String deliverVersion) {
		this.deliverVersion = deliverVersion;
	}
	public String getUATClog() {
		return UATClog;
	}
	public void setUATClog(String uATClog) {
		UATClog = uATClog;
	}
	public String getDBRedis() {
		return DBRedis;
	}
	public void setDBRedis(String dBRedis) {
		DBRedis = dBRedis;
	}
	public String getBUDependence() {
		return BUDependence;
	}
	public void setBUDependence(String bUDependence) {
		BUDependence = bUDependence;
	}
	public String getBugCheck() {
		return bugCheck;
	}
	public void setBugCheck(String bugCheck) {
		this.bugCheck = bugCheck;
	}
	public String getBranchCheck() {
		return branchCheck;
	}
	public void setBranchCheck(String branchCheck) {
		this.branchCheck = branchCheck;
	}
	public String getDevStatus() {
		return devStatus;
	}
	public void setDevStatus(String devStatus) {
		this.devStatus = devStatus;
	}
	public String getTestStatus() {
		return testStatus;
	}
	public void setTestStatus(String testStatus) {
		this.testStatus = testStatus;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public int getDevStatusId() {
		return devStatusId;
	}
	public void setDevStatusId(int devStatusId) {
		this.devStatusId = devStatusId;
	}
	public int getTestStatId() {
		return testStatId;
	}
	public void setTestStatId(int testStatId) {
		this.testStatId = testStatId;
	}

}

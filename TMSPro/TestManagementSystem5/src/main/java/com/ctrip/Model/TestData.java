package com.ctrip.Model;

public class TestData {

	private String department;
	private String groupName;
	private String groupLeader;
	private String groupPNum;
	private Integer testBugScore;
	private Integer testBugNum;
	private Integer availBugNum;
	private Integer wontFixBugNum;
	private Integer cloAndResBugNum;
	private Integer proBugScore;
	private Integer proBugNum;
	private Integer baoleiBackNum;
	private Integer proBackNum;
	private String lostPercent;//=proBugScore/testBugScore
	private Integer prdAndDevNum;//产品、架构建议数=需求+设计
	private Integer comTestOwnerNum;
	private String beginDate;
	private String endDate;
	private String testUser;
	private String testUsers;
	
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupLeader() {
		return groupLeader;
	}
	public void setGroupLeader(String groupLeader) {
		this.groupLeader = groupLeader;
	}
	public String getGroupPNum() {
		return groupPNum;
	}
	public void setGroupPNum(String groupPNum) {
		this.groupPNum = groupPNum;
	}
	public Integer getTestBugScore() {
		return testBugScore;
	}
	public void setTestBugScore(Integer testBugScore) {
		this.testBugScore = testBugScore;
	}
	public Integer getTestBugNum() {
		return testBugNum;
	}
	public void setTestBugNum(Integer testBugNum) {
		this.testBugNum = testBugNum;
	}
	public Integer getAvailBugNum() {
		return availBugNum;
	}
	public void setAvailBugNum(Integer availBugNum) {
		this.availBugNum = availBugNum;
	}
	public Integer getWontFixBugNum() {
		return wontFixBugNum;
	}
	public void setWontFixBugNum(Integer wontFixBugNum) {
		this.wontFixBugNum = wontFixBugNum;
	}
	public Integer getCloAndResBugNum() {
		return cloAndResBugNum;
	}
	public void setCloAndResBugNum(Integer cloAndResBugNum) {
		this.cloAndResBugNum = cloAndResBugNum;
	}
	public Integer getProBugScore() {
		return proBugScore;
	}
	public void setProBugScore(Integer proBugScore) {
		this.proBugScore = proBugScore;
	}
	public Integer getProBugNum() {
		return proBugNum;
	}
	public void setProBugNum(Integer proBugNum) {
		this.proBugNum = proBugNum;
	}
	public Integer getBaoleiBackNum() {
		return baoleiBackNum;
	}
	public void setBaoleiBackNum(Integer baoleiBackNum) {
		this.baoleiBackNum = baoleiBackNum;
	}
	public Integer getProBackNum() {
		return proBackNum;
	}
	public void setProBackNum(Integer proBackNum) {
		this.proBackNum = proBackNum;
	}
	public String getLostPercent() {
		return lostPercent;
	}
	public void setLostPercent(String lostPercent) {
		this.lostPercent = lostPercent;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getTestUser() {
		return testUser;
	}
	public void setTestUser(String testUser) {
		this.testUser = testUser;
	}
	public String getTestUsers() {
		return testUsers;
	}
	public void setTestUsers(String testUsers) {
		this.testUsers = testUsers;
	}
	public Integer getPrdAndDevNum() {
		return prdAndDevNum;
	}
	public void setPrdAndDevNum(Integer prdAndDevNum) {
		this.prdAndDevNum = prdAndDevNum;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Integer getComTestOwnerNum() {
		return comTestOwnerNum;
	}
	public void setComTestOwnerNum(Integer comTestOwnerNum) {
		this.comTestOwnerNum = comTestOwnerNum;
	}

}

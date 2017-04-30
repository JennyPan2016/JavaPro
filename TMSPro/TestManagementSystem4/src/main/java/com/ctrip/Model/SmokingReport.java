package com.ctrip.Model;

import java.util.List;

public class SmokingReport {
	private int id;
	private int projectID;
	private String title;
	private int projectManager;
	private int tester;
	private int developerManager;
	private String projectDeliverTime;
	private String deliverToTestInTime;
	private String scheDeliverToTestTime;
	private String realDeliverToTestTime;
	private String testEnv;
	private String testRound;
	private String smokingResult;
	private String existRisk;
	private int createUserID;
	private List<SmokingReportContent> smokingReportContent;

	private String projectName;
	private String groupName;
	private String projectManagerName;
	private String testerName;
	private String developerManagerName;
	private String createUser;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProjectID() {
		return projectID;
	}
	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}
	public int getProjectManager() {
		return projectManager;
	}
	public void setProjectManager(int projectManager) {
		this.projectManager = projectManager;
	}
	public int getTester() {
		return tester;
	}
	public void setTester(int tester) {
		this.tester = tester;
	}
	public int getDeveloperManager() {
		return developerManager;
	}
	public void setDeveloperManager(int developerManager) {
		this.developerManager = developerManager;
	}
	public String getProjectDeliverTime() {
		return projectDeliverTime;
	}
	public void setProjectDeliverTime(String projectDeliverTime) {
		this.projectDeliverTime = projectDeliverTime;
	}
	public String getDeliverToTestInTime() {
		return deliverToTestInTime;
	}
	public void setDeliverToTestInTime(String deliverToTestInTime) {
		this.deliverToTestInTime = deliverToTestInTime;
	}
	public String getScheDeliverToTestTime() {
		return scheDeliverToTestTime;
	}
	public void setScheDeliverToTestTime(String scheDeliverToTestTime) {
		this.scheDeliverToTestTime = scheDeliverToTestTime;
	}
	public String getRealDeliverToTestTime() {
		return realDeliverToTestTime;
	}
	public void setRealDeliverToTestTime(String realDeliverToTestTime) {
		this.realDeliverToTestTime = realDeliverToTestTime;
	}
	public String getTestEnv() {
		return testEnv;
	}
	public void setTestEnv(String testEnv) {
		this.testEnv = testEnv;
	}
	public String getTestRound() {
		return testRound;
	}
	public void setTestRound(String testRound) {
		this.testRound = testRound;
	}
	public String getSmokingResult() {
		return smokingResult;
	}
	public void setSmokingResult(String smokingResult) {
		this.smokingResult = smokingResult;
	}
	public String getExistRisk() {
		return existRisk;
	}
	public void setExistRisk(String existRisk) {
		this.existRisk = existRisk;
	}
	public int getCreateUserID() {
		return createUserID;
	}
	public void setCreateUserID(int createUserID) {
		this.createUserID = createUserID;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectManagerName() {
		return projectManagerName;
	}
	public void setProjectManagerName(String projectManagerName) {
		this.projectManagerName = projectManagerName;
	}
	public String getTesterName() {
		return testerName;
	}
	public void setTesterName(String testerName) {
		this.testerName = testerName;
	}
	public String getDeveloperManagerName() {
		return developerManagerName;
	}
	public void setDeveloperManagerName(String developerManagerName) {
		this.developerManagerName = developerManagerName;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public List<SmokingReportContent> getSmokingReportContent() {
		return smokingReportContent;
	}
	public void setSmokingReportContent(
			List<SmokingReportContent> smokingReportContent) {
		this.smokingReportContent = smokingReportContent;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}

package com.ctrip.Model;
import java.sql.Date;

public class DeliverList {
	private int id;
	private int projectId;
	private int taskId;
	private String title;
	private String deliverNo;
	private int developer;
	private int tester;
	private String applicationName;
	private String content;
	private String comments;
	private int createUserId;
	private int updateUserId;
	private String createTime;
	private String udpateTime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDeliverNo() {
		return deliverNo;
	}
	public void setDeliverNo(String deliverNo) {
		this.deliverNo = deliverNo;
	}
	public int getDeveloper() {
		return developer;
	}
	public void setDeveloper(int developer) {
		this.developer = developer;
	}
	public int getTester() {
		return tester;
	}
	public void setTester(int tester) {
		this.tester = tester;
	}
	public String getApplicationName() {
		return applicationName;
	}
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public int getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(int createUserId) {
		this.createUserId = createUserId;
	}
	public int getUpdateUserId() {
		return updateUserId;
	}
	public void setUpdateUserId(int updateUserId) {
		this.updateUserId = updateUserId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUdpateTime() {
		return udpateTime;
	}
	public void setUdpateTime(String udpateTime) {
		this.udpateTime = udpateTime;
	}
	

//测试用
	public DeliverList(int id, int projectId, int taskId, String title, String deliverNo, int developer, int tester,
			String applicationName, String content, String comments, int createUserId, int updateUserId) {
		super();
		this.id = id;
		this.projectId = projectId;
		this.taskId = taskId;
		this.title = title;
		this.deliverNo = deliverNo;
		this.developer = developer;
		this.tester = tester;
		this.applicationName = applicationName;
		this.content = content;
		this.comments = comments;
		this.createUserId = createUserId;
		this.updateUserId = updateUserId;
	}
	public DeliverList(){}

	
	
}

package com.ctrip.Model;

public class SmokingReportContent {
	private int id;
	private int smokingReportID;
	private String testpoint;
	private String testResult;
	private String remarks;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSmokingReportID() {
		return smokingReportID;
	}
	public void setSmokingReportID(int smokingReportID) {
		this.smokingReportID = smokingReportID;
	}
	public String getTestpoint() {
		return testpoint;
	}
	public void setTestpoint(String testpoint) {
		this.testpoint = testpoint;
	}
	public String getTestResult() {
		return testResult;
	}
	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}

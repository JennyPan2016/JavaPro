package com.ctrip.Model;

public class Log {
	
	private int id;
	private int userid;
	private String OperationType;
	private String OperationModel;
	private String OperationDetail;
	private String Remarks;
	private String CreateTime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getOperationType() {
		return OperationType;
	}
	public void setOperationType(String operationType) {
		OperationType = operationType;
	}
	public String getOperationModel() {
		return OperationModel;
	}
	public void setOperationModel(String operationModel) {
		OperationModel = operationModel;
	}
	public String getOperationDetail() {
		return OperationDetail;
	}
	public void setOperationDetail(String operationDetail) {
		OperationDetail = operationDetail;
	}
	public String getRemarks() {
		return Remarks;
	}
	public void setRemarks(String remarks) {
		Remarks = remarks;
	}
	public String getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}

}

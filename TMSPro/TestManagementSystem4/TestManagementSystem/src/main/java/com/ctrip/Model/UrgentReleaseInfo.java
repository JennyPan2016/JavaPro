package com.ctrip.Model;

public class UrgentReleaseInfo {
	Integer id;
	//发布类型：程序bug、业务需求、产品缺陷、第三方问题、计划外、技术优化
	String releaseType;
	String appid;
	//申请人
	Integer applicant;
	
	//部门，产品，产线，产品
	Integer departmentId;
	Integer centerId;
    Integer groupId;
    Integer productId;
    
    //申请时间
    String appliedTime;
    //紧急发布原因
	String urgentReleaseReason;
	Integer developerId;
	Integer testerId;
	String releaseRisk;
	String releaseVersion;
	String description;
	Integer createUserId;
	Integer updateUserId;
	String createTime;
	String updateTime;
	String releaseFinishedTime;
	
	String applicantName;
	String createUser;
	String updateUser;
	String department;
	String center;
	String groupName;
	String productName;
	String developer;
	String tester;
	String startTime;
	String endTime;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getReleaseType() {
		return releaseType;
	}
	public void setReleaseType(String releaseType) {
		this.releaseType = releaseType;
	}
	
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	
	public Integer getApplicant() {
		return applicant;
	}
	public void setApplicant(Integer applicant) {
		this.applicant = applicant;
	}
	
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	
	public String getAppliedTime() {
		return appliedTime;
	}
	public void setAppliedTime(String appliedTime) {
		this.appliedTime = appliedTime;
	}
	
	public String getUrgentReleaseReason() {
		return urgentReleaseReason;
	}
	public void setUrgentReleaseReason(String urgentReleaseReason) {
		this.urgentReleaseReason = urgentReleaseReason;
	}
	
	public Integer getDeveloperId() {
		return developerId;
	}
	public void setDeveloperId(Integer developerId) {
		this.developerId = developerId;
	}
	
	public Integer getTesterId() {
		return testerId;
	}
	public void setTesterId(Integer testerId) {
		this.testerId = testerId;
	}
	
	public String getReleaseRisk() {
		return releaseRisk;
	}
	public void setReleaseRisk(String releaseRisk) {
		this.releaseRisk = releaseRisk;
	}
	
	public String getReleaseVersion() {
		return releaseVersion;
	}
	public void setReleaseVersion(String releaseVersion) {
		this.releaseVersion = releaseVersion;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}
	public Integer getUpdateUserId() {
		return updateUserId;
	}
	public void setUpdateUserId(Integer updateUserId) {
		this.updateUserId = updateUserId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
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
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCenter() {
		return center;
	}
	public void setCenter(String center) {
		this.center = center;
	}
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	public Integer getCenterId() {
		return centerId;
	}
	public void setCenterId(Integer centerId) {
		this.centerId = centerId;
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
	public String getReleaseFinishedTime() {
		return releaseFinishedTime;
	}
	public void setReleaseFinishedTime(String releaseFinishedTime) {
		this.releaseFinishedTime = releaseFinishedTime;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}	
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getApplicantName() {
		return applicantName;
	}
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}
}

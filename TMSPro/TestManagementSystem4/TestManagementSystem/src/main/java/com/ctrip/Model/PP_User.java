package com.ctrip.Model;

public class PP_User {
	private int id;
	private String userName;
	private String userAlias;
	private String email;
	private int productId;
	private int groupId;
	private int centerId;
	private int userRole;
	private int userTitle;
	
	private String DepartmentName;
	private String CenterName;
	private String GroupName;
	private String ProductName;
	private String RoleName;
	private String TitleName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAlias() {
		return userAlias;
	}
	public void setUserAlias(String userAlias) {
		this.userAlias = userAlias;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public int getCenterId() {
		return centerId;
	}
	public void setCenterId(int centerId) {
		this.centerId = centerId;
	}
	public int getUserRole() {
		return userRole;
	}
	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}
	public int getUserTitle() {
		return userTitle;
	}
	public void setUserTitle(int userTitle) {
		this.userTitle = userTitle;
	}
	public String getDepartmentName() {
		return DepartmentName;
	}
	public void setDepartmentName(String departmentName) {
		DepartmentName = departmentName;
	}
	public String getCenterName() {
		return CenterName;
	}
	public void setCenterName(String centerName) {
		CenterName = centerName;
	}
	public String getGroupName() {
		return GroupName;
	}
	public void setGroupName(String groupName) {
		GroupName = groupName;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public String getRoleName() {
		return RoleName;
	}
	public void setRoleName(String roleName) {
		RoleName = roleName;
	}
	public String getTitleName() {
		return TitleName;
	}
	public void setTitleName(String titleName) {
		TitleName = titleName;
	}
}

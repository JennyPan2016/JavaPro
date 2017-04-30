package com.ctrip.Model;

public class RoleModule {

	private int id;
	private int RoleID;
	private int ModuleID;
	private String Description;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoleID() {
		return RoleID;
	}
	public void setRoleID(int roleID) {
		RoleID = roleID;
	}
	public int getModuleID() {
		return ModuleID;
	}
	public void setModuleID(int moduleID) {
		ModuleID = moduleID;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
}

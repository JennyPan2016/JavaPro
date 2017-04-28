package com.ctrip.web;

import com.ctrip.DAO.UserRoleDAO;
import java.util.ArrayList;
import org.apache.struts2.ServletActionContext;
import com.ctrip.Model.UserRole;

public class UserRoleAction {
	
	public void UserRoleList()
	{
		ArrayList<UserRole> al=UserRoleDAO.getRoleNameList();
		ServletActionContext.getRequest().setAttribute("UserRoleList", al);
		
	}
}

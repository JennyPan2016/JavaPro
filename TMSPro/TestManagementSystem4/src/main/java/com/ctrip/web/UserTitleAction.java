package com.ctrip.web;

import java.util.ArrayList;

import org.apache.struts2.ServletActionContext;

import com.ctrip.DAO.UserTitleDAO;
import com.ctrip.Model.UserTitle;

public class UserTitleAction {
	
	public static void UserTitleList()
	{
		String groupid = ServletActionContext.getRequest().getParameter("groupid");
		
		ArrayList<UserTitle> al=UserTitleDAO.getUserTitleList(Integer.parseInt(groupid));
		ServletActionContext.getRequest().setAttribute("UserTitleList", al);
	}
}

package com.ctrip.web;

import java.util.ArrayList;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;

import com.ctrip.DAO.PP_UserDAO;
import com.ctrip.Model.PP_User;

public class PP_UserAction {

	/*
	 * author: went
	 */
	public void deleteUser()
	{
		String userid = ServletActionContext.getRequest().getParameter("userid");
		JSONArray json = new JSONArray();
		JSONObject jo = new JSONObject();
		
		String result = "";
		result = PP_UserDAO.deleteUser(Integer.parseInt(userid));
			
		if (result.contains("Success")){
			jo.put("status", "0");
			jo.put("message", "success");
			json.put(jo);
		}else{
			ServletActionContext.getRequest().setAttribute("errorMsg", result);
			jo.put("status", "1");
			jo.put("message", result);
			json.put(jo);
		}
		
		try
		{
			ServletActionContext.getResponse().setHeader("content-type", "application/json");
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			ServletActionContext.getResponse().getWriter().write(json.toString());
			
		 }catch(Exception e){
			 ServletActionContext.getRequest().setAttribute("errorMsg", e.toString());
		 }
	}
	/*
	 * author: went
	 */
	public void getUserinfo()
	{
		String DepartmentName = ServletActionContext.getRequest().getParameter("DepartmentName");
		String CenterName = ServletActionContext.getRequest().getParameter("CenterName");
		String GroupName = ServletActionContext.getRequest().getParameter("GroupName");
		String UserAlias = ServletActionContext.getRequest().getParameter("UserAlias");

		ArrayList<PP_User> al=new ArrayList<PP_User>();
		al=PP_UserDAO.getUserinfo(DepartmentName, CenterName, GroupName, UserAlias);
		
		
		JSONArray json = new JSONArray();
		JSONObject jo = new JSONObject();
		
		if(al.size() == 0){  
			ServletActionContext.getRequest().setAttribute("errorMsg", "未查询到数据");
			jo.put("status", "1");
			jo.put("message", "未查询到数据");
			json.put(jo);}
		else{
			 for (PP_User key :al){  
				 jo.put("userid", key.getId());
				 jo.put("DepartmentName", key.getDepartmentName());
				 jo.put("CenterName", key.getCenterName());
				 jo.put("GroupName", key.getGroupName());
				 jo.put("UserAlias", key.getUserAlias());//用户域名
				 jo.put("UserName", key.getUserName());//用户真实名字，预留
				 jo.put("setEmail", key.getEmail());
				 jo.put("RoleName", key.getRoleName());
				 jo.put("TitleName", key.getTitleName());
				 json.put(jo);
		     }  
		}
		
	}
	/*
	 * author: went
	 */
	public void adduser(){
		String userName = ServletActionContext.getRequest().getParameter("userName");
		String userAlias = ServletActionContext.getRequest().getParameter("userAlias");
		String email = ServletActionContext.getRequest().getParameter("email");
		String groupid = ServletActionContext.getRequest().getParameter("groupid");
		String userRole = ServletActionContext.getRequest().getParameter("userRoleid");
		String userTitle = ServletActionContext.getRequest().getParameter("userTitleid");
		
		JSONArray json = new JSONArray();
		JSONObject jo = new JSONObject();
		
		PP_User user=new PP_User();
		user.setUserName(userName);
		user.setUserAlias(userAlias);
		user.setEmail(email);
		user.setGroupId(Integer.parseInt(groupid));
		user.setUserRole(Integer.parseInt(userRole));
		user.setUserTitle(Integer.parseInt(userTitle));
		
		String result = "";
		result = PP_UserDAO.addUser(user);
		
		if (result.contains("Success")){
			jo.put("status", "0");
			jo.put("message", "success");
			json.put(jo);
		}else{
			ServletActionContext.getRequest().setAttribute("errorMsg", result);
			jo.put("status", "1");
			jo.put("message", result);
			json.put(jo);
		}
		
		try
		{
			ServletActionContext.getResponse().setHeader("content-type", "application/json");
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			ServletActionContext.getResponse().getWriter().write(json.toString());
			
		 }catch(Exception e){
			 ServletActionContext.getRequest().setAttribute("errorMsg", e.toString());
		 }
	}	
	
	public void updateuser(){
		
		String userid = ServletActionContext.getRequest().getParameter("userid");
		String userAlias = ServletActionContext.getRequest().getParameter("userAlias");
		String groupid = ServletActionContext.getRequest().getParameter("groupid");
		String userRole = ServletActionContext.getRequest().getParameter("userRoleid");
		String userTitle = ServletActionContext.getRequest().getParameter("userTitleid");
		
		JSONArray json = new JSONArray();
		JSONObject jo = new JSONObject();
		
		PP_User user=new PP_User();
		user.setId(Integer.parseInt(userid));
		user.setUserAlias(userAlias);
		user.setUserRole(Integer.parseInt(userRole));
		user.setUserTitle(Integer.parseInt(userTitle));
		user.setGroupId(Integer.parseInt(groupid));
		
		String result = "";
		result = PP_UserDAO.updateUser(user);
			
		if (result.contains("Success")){
			jo.put("status", "0");
			jo.put("message", "success");
			json.put(jo);
		}else{
			ServletActionContext.getRequest().setAttribute("errorMsg", result);
			jo.put("status", "1");
			jo.put("message", result);
			json.put(jo);
		}
		
		try
		{
			ServletActionContext.getResponse().setHeader("content-type", "application/json");
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			ServletActionContext.getResponse().getWriter().write(json.toString());
			
		 }catch(Exception e){
			 ServletActionContext.getRequest().setAttribute("errorMsg", e.toString());
		 }
	}	
}

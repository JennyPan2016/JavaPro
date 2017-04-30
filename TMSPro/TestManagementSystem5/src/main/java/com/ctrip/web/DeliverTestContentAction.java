package com.ctrip.web;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;

import com.ctrip.DAO.DeliverTestContentDAO;
import com.ctrip.Model.DeliverTestContent;

public class DeliverTestContentAction {
	/*
	 * author: full
	 */
	public void saveDeliverTestContent(){
		String groupName = ServletActionContext.getRequest().getParameter("groupName");
		String projectName = ServletActionContext.getRequest().getParameter("projectName");
		String description = ServletActionContext.getRequest().getParameter("description");
		String serviceName = ServletActionContext.getRequest().getParameter("serviceName");
		String changePoint = ServletActionContext.getRequest().getParameter("changePoint");
		String changeContent = ServletActionContext.getRequest().getParameter("changeContent");
		String changeDescription = ServletActionContext.getRequest().getParameter("changeDescription");
		String emailList = ServletActionContext.getRequest().getParameter("emailList");
		String createUser = ServletActionContext.getRequest().getParameter("createUser");
		String updateUser = ServletActionContext.getRequest().getParameter("updateUser");
		
		JSONArray json = new JSONArray();
		JSONObject jo = new JSONObject();
		
		if(true){
			String result = "";
			DeliverTestContent testContent = new DeliverTestContent();
			testContent.setGroupName(groupName);
			testContent.setProjectName(projectName);
			testContent.setDescription(description);
			testContent.setServiceName(serviceName);
			testContent.setChangePoint(changePoint);
			testContent.setChangeContent(changeContent);
			testContent.setChangeDescription(changeDescription);
			testContent.setEmailList(emailList);
			testContent.setCreateUser(createUser);
			testContent.setUpdateUser(updateUser);
			
			DeliverTestContentDAO contentDao = new DeliverTestContentDAO();
			result = contentDao.saveDeliverTestContent(testContent);
			
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
		}else{
			jo.put("status", "2");
			jo.put("message", "Sorry! 您没有权限做该项操作。");
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
	 * author: full
	 */
	public void updateDeliverTestContent(){
		String id = ServletActionContext.getRequest().getParameter("id");
		String groupName = ServletActionContext.getRequest().getParameter("groupName");
		String projectName = ServletActionContext.getRequest().getParameter("projectName");
		String description = ServletActionContext.getRequest().getParameter("description");
		String serviceName = ServletActionContext.getRequest().getParameter("serviceName");
		String changePoint = ServletActionContext.getRequest().getParameter("changePoint");
		String changeContent = ServletActionContext.getRequest().getParameter("changeContent");
		String changeDescription = ServletActionContext.getRequest().getParameter("changeDescription");
		String emailList = ServletActionContext.getRequest().getParameter("emailList");
		String updateUser = ServletActionContext.getRequest().getParameter("updateUser");
		
		JSONArray json = new JSONArray();
		JSONObject jo = new JSONObject();
		
		if(true){
			String result = "";
			DeliverTestContent testContent = new DeliverTestContent();
			testContent.setId(Integer.parseInt(id));
			testContent.setGroupName(groupName);
			testContent.setProjectName(projectName);
			testContent.setDescription(description);
			testContent.setServiceName(serviceName);
			testContent.setChangePoint(changePoint);
			testContent.setChangeContent(changeContent);
			testContent.setChangeDescription(changeDescription);
			testContent.setEmailList(emailList);
			testContent.setUpdateUser(updateUser);
			
			DeliverTestContentDAO contentDao = new DeliverTestContentDAO();
			result = contentDao.updateDeliverTestContent(testContent);
			
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
		}else{
			jo.put("status", "2");
			jo.put("message", "Sorry! 您没有权限做该项操作。");
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
	
	public void queryDeliverTestContent(){
		String groupName = ServletActionContext.getRequest().getParameter("groupName");
		String projectName = ServletActionContext.getRequest().getParameter("projectName");
		
		JSONArray json = new JSONArray();
		DeliverTestContent testContent = new DeliverTestContent();
		testContent.setGroupName(groupName);
		testContent.setProjectName(projectName);
		
		DeliverTestContentDAO contentDao = new DeliverTestContentDAO();
		json = contentDao.queryDeliverTestContent(testContent);
		
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

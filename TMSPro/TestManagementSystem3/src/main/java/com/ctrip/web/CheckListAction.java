package com.ctrip.web;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;

import com.ctrip.DAO.CheckListDAO;
import com.ctrip.Model.CheckList;

public class CheckListAction {
	/*
	 * author: full
	 */
	public void saveCheckListInfo(){
		String groupName = ServletActionContext.getRequest().getParameter("groupName");
		String projectName = ServletActionContext.getRequest().getParameter("projectName");
		String taskName = ServletActionContext.getRequest().getParameter("taskName");
		String deliverTime = ServletActionContext.getRequest().getParameter("deliverTime"); //时间格式：2017-04-15
		String deliverVersion = ServletActionContext.getRequest().getParameter("deliverVersion");  
		String UATClog = ServletActionContext.getRequest().getParameter("UATClog");
		String DBRedis = ServletActionContext.getRequest().getParameter("DBRedis");
		String BUDependence = ServletActionContext.getRequest().getParameter("BUDependence");
		String bugCheck = ServletActionContext.getRequest().getParameter("bugCheck");
		String branchCheck = ServletActionContext.getRequest().getParameter("branchCheck");
		String devStatus = ServletActionContext.getRequest().getParameter("devStatus"); //0: 未确认； 1：确认
		String testStatus = ServletActionContext.getRequest().getParameter("testStatus"); 
		String remarks = ServletActionContext.getRequest().getParameter("remarks");
		
		JSONArray json = new JSONArray();
		JSONObject jo = new JSONObject();
		
		if(true){
			String result = "";
			CheckList checkList = new CheckList();
			checkList.setGroupName(groupName);
			checkList.setProjectName(projectName);
			checkList.setTaskName(taskName);
			checkList.setDeliverTime(deliverTime);
			checkList.setDeliverVersion(deliverVersion);
			checkList.setUATClog(UATClog);
			checkList.setDBRedis(DBRedis);
			checkList.setBUDependence(BUDependence);
			checkList.setBugCheck(bugCheck);
			checkList.setBranchCheck(branchCheck);
			checkList.setDevStatus(devStatus);
			checkList.setTestStatus(testStatus);
			checkList.setRemark(remarks);
			
			CheckListDAO checkListDao = new CheckListDAO();
			result = checkListDao.saveCheckList(checkList);
			
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
	
	public void updateCheckListInfo(){
		String id = ServletActionContext.getRequest().getParameter("id");
		String groupName = ServletActionContext.getRequest().getParameter("groupName");
		String projectName = ServletActionContext.getRequest().getParameter("projectName");
		String taskName = ServletActionContext.getRequest().getParameter("taskName");
		String deliverTime = ServletActionContext.getRequest().getParameter("deliverTime"); //时间格式：2017-04-15
		String deliverVersion = ServletActionContext.getRequest().getParameter("deliverVersion");  
		String UATClog = ServletActionContext.getRequest().getParameter("UATClog");
		String DBRedis = ServletActionContext.getRequest().getParameter("DBRedis");
		String BUDependence = ServletActionContext.getRequest().getParameter("BUDependence");
		String bugCheck = ServletActionContext.getRequest().getParameter("bugCheck");
		String branchCheck = ServletActionContext.getRequest().getParameter("branchCheck");
		String devStatus = ServletActionContext.getRequest().getParameter("devStatus"); //0: 未确认； 1：确认
		String testStatus = ServletActionContext.getRequest().getParameter("testStatus"); 
		String remarks = ServletActionContext.getRequest().getParameter("remarks");
		
		JSONArray json = new JSONArray();
		JSONObject jo = new JSONObject();
		
		if(true){
			String result = "";
			CheckList checkList = new CheckList();
			checkList.setId(Integer.parseInt(id));
			checkList.setGroupName(groupName);
			checkList.setProjectName(projectName);
			checkList.setTaskName(taskName);
			checkList.setDeliverTime(deliverTime);
			checkList.setDeliverVersion(deliverVersion);
			checkList.setUATClog(UATClog);
			checkList.setDBRedis(DBRedis);
			checkList.setBUDependence(BUDependence);
			checkList.setBugCheck(bugCheck);
			checkList.setBranchCheck(branchCheck);
			checkList.setDevStatus(devStatus);
			checkList.setTestStatus(testStatus);
			checkList.setRemark(remarks);
			
			CheckListDAO checkListDao = new CheckListDAO();
			result = checkListDao.updateCheckList(checkList);
			
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
}

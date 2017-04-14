package com.ctrip.web;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;

import com.ctrip.DAO.TaskDAO;
import com.ctrip.Model.Task;

public class TaskAction {
	/*
	 * author: full
	 */
	public void saveTaskInfo(){
		String taskName = ServletActionContext.getRequest().getParameter("taskName");
		String description = ServletActionContext.getRequest().getParameter("description");
		String status = ServletActionContext.getRequest().getParameter("status"); //0:未开始；1：进行中；2：已结束 
		String groupName = ServletActionContext.getRequest().getParameter("groupName");
		String projectName = ServletActionContext.getRequest().getParameter("projectName");
		String developer = ServletActionContext.getRequest().getParameter("developer");
		String tester = ServletActionContext.getRequest().getParameter("tester");
		String combinedAdjustingOwner = ServletActionContext.getRequest().getParameter("combinedAdjustingOwner");
		String combinedAdjustingTime = ServletActionContext.getRequest().getParameter("combinedAdjustingTime"); //时间格式：2017-04-11
		String createUser = ServletActionContext.getRequest().getParameter("createUser");
		String updateUser = ServletActionContext.getRequest().getParameter("updateUser");
		
		JSONArray json = new JSONArray();
		JSONObject jo = new JSONObject();
		
		if(true){
			String result = "";
			Task task = new Task();
			task.setTaskName(taskName);
			task.setDescription(description);
			task.setStatus(status);
			task.setGroupName(groupName);
			task.setProjectName(projectName);
			task.setDeveloper(developer);
			task.setTester(tester);
			task.setComAdjustingOwner(combinedAdjustingOwner);
			task.setCombinedAdjustingTime(combinedAdjustingTime);
			task.setCreateUser(createUser);
			task.setUpdateUser(updateUser);
			
			TaskDAO taskDao = new TaskDAO();
			result = taskDao.saveTask(task);
			
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

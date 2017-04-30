package com.ctrip.web;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;

import com.ctrip.DAO.ProjectDAO;
import com.ctrip.Model.Project;

public class ProjectAction {
	/*
	 * author: full
	 */
	public void saveProjectInfo(){
		String projectName = ServletActionContext.getRequest().getParameter("projectName");
		String description = ServletActionContext.getRequest().getParameter("description");
		String productName = ServletActionContext.getRequest().getParameter("productName");
		String groupName = ServletActionContext.getRequest().getParameter("groupName");
		String centerName = ServletActionContext.getRequest().getParameter("centerName");
		String status = ServletActionContext.getRequest().getParameter("status"); //0:未开始；1：进行中；2：已结束 
		String projectType = ServletActionContext.getRequest().getParameter("projectType"); //0:Project; 1:CR
		String BAOwner = ServletActionContext.getRequest().getParameter("BAOwner");
		String ADOwner = ServletActionContext.getRequest().getParameter("ADOwner");
		String STOwner = ServletActionContext.getRequest().getParameter("STOwner");
		String develops = ServletActionContext.getRequest().getParameter("develops"); //前端需要一个复选框的形式，以："张三,李四,王五"的形式提交到后台
		String testers = ServletActionContext.getRequest().getParameter("testers"); //前端需要一个复选框的形式，以："张三,李四,王五"的形式提交到后台
		String scheSmokingTime = ServletActionContext.getRequest().getParameter("scheSmokingTime"); //日期格式：2017-04-11
		String scheDeliverTime = ServletActionContext.getRequest().getParameter("scheDeliverTime");
		String realDeliverTime = ServletActionContext.getRequest().getParameter("realDeliverTime");
		String testCompleteTime = ServletActionContext.getRequest().getParameter("testCompleteTime");
		String needCombinedAdjusting = ServletActionContext.getRequest().getParameter("needCombinedAdjusting"); //0:需要；1:不需要
		String combinedAdjustingTime = ServletActionContext.getRequest().getParameter("combinedAdjustingTime");
		String needPerformanceTest = ServletActionContext.getRequest().getParameter("needPerformanceTest"); //0:需要；1:不需要
		String projectRisk = ServletActionContext.getRequest().getParameter("projectRisk");
		String riskSolution = ServletActionContext.getRequest().getParameter("riskSolution");
		String createUser = ServletActionContext.getRequest().getParameter("createUser");
		String updateUser = ServletActionContext.getRequest().getParameter("updateUser");
		
		JSONArray json = new JSONArray();
		JSONObject jo = new JSONObject();
		
		if(true){
			String result = "";
			Project project = new Project();
			project.setProjectName(projectName);
			project.setDescription(description);
			project.setProductName(productName);
			project.setGroupName(groupName);
			project.setCenterName(centerName);
			project.setStatus(status);
			project.setProjectType(projectType);
			project.setBAOwner(BAOwner);
			project.setADOwner(ADOwner);
			project.setSTOwner(STOwner);
			project.setDevelops(develops);
			project.setTesters(testers);
			project.setScheSmokingTime(scheSmokingTime);
			project.setScheDeliverTime(scheDeliverTime);
			project.setRealDeliverTime(realDeliverTime);
			project.setTestCompleteTime(testCompleteTime);
			project.setNeedCombinedAdjusting(needCombinedAdjusting);
			project.setCombinedAdjustingTime(combinedAdjustingTime);
			project.setNeedPerformanceTest(needPerformanceTest);
			project.setProjectRisk(projectRisk);
			project.setRiskSolution(riskSolution);
			project.setCreateUser(createUser);
			project.setUpdateUser(updateUser);
			
			ProjectDAO projectDao = new ProjectDAO();
			result = projectDao.saveProject(project);
			
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

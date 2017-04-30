package com.ctrip.web;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;

import com.ctrip.DAO.SmokingReportDAO;
import com.ctrip.Model.SmokingReport;
import com.ctrip.Model.SmokingReportContent;

public class SmokingReportAction {
	/*
	 * author: full
	 */
	public void saveSmokingReport(){
		String projectId = ServletActionContext.getRequest().getParameter("projectId");
		String title = ServletActionContext.getRequest().getParameter("title");
		String testerId = ServletActionContext.getRequest().getParameter("testerId");
		String developerManagerId = ServletActionContext.getRequest().getParameter("developerManagerId"); 
		String projectDeliverTime = ServletActionContext.getRequest().getParameter("projectDeliverTime");//时间格式：2017-04-11
		String deliverToTestInTime = ServletActionContext.getRequest().getParameter("deliverToTestInTime"); //0:是；1:否
		String scheDeliverToTestTime = ServletActionContext.getRequest().getParameter("scheDeliverToTestTime");
		String realDeliverToTestTime = ServletActionContext.getRequest().getParameter("realDeliverToTestTime");
		String testEnv = ServletActionContext.getRequest().getParameter("testEnv");
		String testRound = ServletActionContext.getRequest().getParameter("testRound"); 
		String smokingResult = ServletActionContext.getRequest().getParameter("smokingResult"); //0:成功；1:失败
		String existRisk = ServletActionContext.getRequest().getParameter("existRisk");
		String createUser = ServletActionContext.getRequest().getParameter("createUser");
		
		JSONArray json = new JSONArray();
		JSONObject jo = new JSONObject();
		
		if(true){
			String result = "";
			SmokingReport smokingReport = new SmokingReport();
			smokingReport.setProjectID(Integer.parseInt(projectId));
			smokingReport.setTitle(title);
			smokingReport.setTester(Integer.parseInt(testerId));
			smokingReport.setDeveloperManager(Integer.parseInt(developerManagerId));
			smokingReport.setProjectDeliverTime(projectDeliverTime);
			smokingReport.setDeliverToTestInTime(deliverToTestInTime);
			smokingReport.setScheDeliverToTestTime(scheDeliverToTestTime);
			smokingReport.setRealDeliverToTestTime(realDeliverToTestTime);
			smokingReport.setTestEnv(testEnv);
			smokingReport.setTestRound(testRound);
			smokingReport.setSmokingResult(smokingResult);
			smokingReport.setExistRisk(existRisk);
			smokingReport.setCreateUser(createUser);
			
			SmokingReportDAO sReportDao = new SmokingReportDAO();
			result = sReportDao.saveSmokingReport(smokingReport);
			
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
	
	public void saveSmokingReportContent(){
		String smokingReportID = ServletActionContext.getRequest().getParameter("smokingReportID");
		String testPoint = ServletActionContext.getRequest().getParameter("testPoint");
		String testResult = ServletActionContext.getRequest().getParameter("testResult");  //0:成功；1:失败
		String remarks = ServletActionContext.getRequest().getParameter("remarks");
		
		JSONArray json = new JSONArray();
		JSONObject jo = new JSONObject();
		
		if(true){
			String result = "";
			SmokingReportContent smokingReportContent = new SmokingReportContent();
			smokingReportContent.setSmokingReportID(Integer.parseInt(smokingReportID));
			smokingReportContent.setTestpoint(testPoint);
			smokingReportContent.setTestResult(testResult);
			smokingReportContent.setRemarks(remarks);
			
			SmokingReportDAO sReportDao = new SmokingReportDAO();
			result = sReportDao.saveSmokingReportContent(smokingReportContent);
			
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

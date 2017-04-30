package com.ctrip.web;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;

import com.ctrip.DAO.AuthorizationDAO;
import com.ctrip.DAO.DeliverListDAO;
import com.ctrip.DAO.PP_UserDAO;
import com.ctrip.Model.DeliverList;
import com.opensymphony.xwork2.ActionSupport;

public class DeliverListAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;

	/*
	 * 添加一个发布单,pan.jing
	 * */
	public void addDeliverList(){	
		
		String title = ServletActionContext.getRequest().getParameter("title");	
		String groupId = ServletActionContext.getRequest().getParameter("groupId"); 
		String projectId = ServletActionContext.getRequest().getParameter("projectId"); 
		String taskId = ServletActionContext.getRequest().getParameter("taskId");   
		String developerId = ServletActionContext.getRequest().getParameter("developerId");
		String testerId = ServletActionContext.getRequest().getParameter("testerId");
		String deliverNo = ServletActionContext.getRequest().getParameter("deliverNo");
		String content = ServletActionContext.getRequest().getParameter("content");
		String comments = ServletActionContext.getRequest().getParameter("comments");
		String createUser = ServletActionContext.getRequest().getParameter("createUser");	
		String appId = ServletActionContext.getRequest().getParameter("appId");
		String deliverType = ServletActionContext.getRequest().getParameter("deliverType");
		String status = ServletActionContext.getRequest().getParameter("status");
	/*try {                                                             
			title = new String(title.getBytes("8859_1"), "utf8"); //调试：get方式请求将url中的中文转码为utf8
			groupId = new String(groupId.getBytes("8859_1"), "utf8");
			projectId = new String(projectId.getBytes("8859_1"), "utf8");
			taskId = new String(taskId.getBytes("8859_1"), "utf8");
			appId = new String(appId.getBytes("8859_1"), "utf8");
			deliverType = new String(deliverType.getBytes("8859_1"), "utf8");
			developerId = new String(developerId.getBytes("8859_1"), "utf8");
			testerId = new String(testerId.getBytes("8859_1"), "utf8");
			status = new String(status.getBytes("8859_1"), "utf8");
			deliverNo = new String(deliverNo.getBytes("8859_1"), "utf8");
			content = new String(content.getBytes("8859_1"), "utf8");
			comments = new String(comments.getBytes("8859_1"), "utf8");
			createUser = new String(createUser.getBytes("8859_1"), "utf8");	
			appId = new String(appId.getBytes("8859_1"), "utf8");	
			deliverType = new String(deliverType.getBytes("8859_1"), "utf8");
			status = new String(status.getBytes("8859_1"), "utf8");	
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}*/
		boolean auth = false;
		auth = AuthorizationDAO.Authorization(PP_UserDAO.getGroupIDByUserID(Integer.valueOf(groupId)), Integer.valueOf(PP_UserDAO.getIdByUserName(createUser))); //权限
		
		JSONArray jsona = new JSONArray();
		JSONObject jO = new JSONObject();
		if(auth){			
			DeliverList dList = new DeliverList();			
			dList.setProjectId(Integer.valueOf(projectId)); 
			dList.setTaskId(Integer.valueOf(taskId));
			dList.setTitle(title);
			dList.setDeliverNo(deliverNo);
			dList.setDeveloperId(Integer.valueOf(developerId));
			dList.setTesterId(Integer.valueOf(testerId));
			dList.setContent(content);
			dList.setComments(comments);
			dList.setCreateUserId(Integer.valueOf(PP_UserDAO.getIdByUserName(createUser)));
			dList.setAppId(appId);
			dList.setStatus(status);
			dList.setDeliverType(deliverType);
			
			
			DeliverListDAO dListDAO = new DeliverListDAO();				
			String result = dListDAO.insertDeliverList(dList);			
			if(result.contains("Success")){  
				jO.put("status", "0");
				jO.put("message", "success");
				jsona.put(jO);	
			}else{
				ServletActionContext.getRequest().setAttribute("errorMsg", result);
				jO.put("status", "1");
				jO.put("message", result);
				jsona.put(jO);	
			}
		}else{
			jO.put("status", "2");
			jO.put("message", "Sorry! 您没有权限做该项操作。");
			jsona.put(jO);
		}		
		try{
			ServletActionContext.getResponse().setHeader("content-type", "application/json");
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			ServletActionContext.getResponse().getWriter().write(jsona.toString());
		}catch(Exception e){
			e.printStackTrace();
		}	
	}

	
	/*
	 * 更新发布单内容,pan.jing
	 */
	public void modifyDeliverList(){
		String deliverId = ServletActionContext.getRequest().getParameter("deliverId");
		String title = ServletActionContext.getRequest().getParameter("title");	 
		String projectId = ServletActionContext.getRequest().getParameter("projectId"); 
		String taskId = ServletActionContext.getRequest().getParameter("taskId");   
		String developerId = ServletActionContext.getRequest().getParameter("developerId");
		String testerId = ServletActionContext.getRequest().getParameter("testerId");
		String deliverNo = ServletActionContext.getRequest().getParameter("deliverNo");
		String content = ServletActionContext.getRequest().getParameter("content");
		String comments = ServletActionContext.getRequest().getParameter("comments");
		String createUserId = ServletActionContext.getRequest().getParameter("createUserId");	
		String appId = ServletActionContext.getRequest().getParameter("appId");
		String deliverType = ServletActionContext.getRequest().getParameter("deliverType");
		String status = ServletActionContext.getRequest().getParameter("status");
		String updateUser = ServletActionContext.getRequest().getParameter("updateUser");
		try {  
			deliverId = new String(deliverId.getBytes("8859_1"), "utf8");
			title = new String(title.getBytes("8859_1"), "utf8"); //调试：get方式请求将url中的中文转码为utf8
			projectId = new String(projectId.getBytes("8859_1"), "utf8");
			taskId = new String(taskId.getBytes("8859_1"), "utf8");
			developerId = new String(developerId.getBytes("8859_1"), "utf8");
			testerId = new String(testerId.getBytes("8859_1"), "utf8");
			deliverNo = new String(deliverNo.getBytes("8859_1"), "utf8");
			content = new String(content.getBytes("8859_1"), "utf8");
			comments = new String(comments.getBytes("8859_1"), "utf8");			
			appId = new String(appId.getBytes("8859_1"), "utf8");	
			deliverType = new String(deliverType.getBytes("8859_1"), "utf8");
			status = new String(status.getBytes("8859_1"), "utf8");		
			updateUser = new String(updateUser.getBytes("8859_1"), "utf8");	
	} catch (UnsupportedEncodingException e1) {
		e1.printStackTrace();
	}
		int userId  = PP_UserDAO.getIdByUserName(updateUser);
		boolean auth = false;
		auth = AuthorizationDAO.Authorization(PP_UserDAO.getGroupIDByUserID(Integer.valueOf(userId)), Integer.valueOf(PP_UserDAO.getIdByUserName(updateUser))); //权限
		
		JSONArray jsona=new JSONArray();
		JSONObject jO=new JSONObject();
		if(auth){
			DeliverList dList = new DeliverList();			
			dList.setId(Integer.valueOf(deliverId));
			dList.setProjectId(Integer.valueOf(projectId)); 
			dList.setTaskId(Integer.valueOf(taskId));
			dList.setTitle(title);
			dList.setDeliverNo(deliverNo);
			dList.setDeveloperId(Integer.valueOf(developerId));
			dList.setTesterId(Integer.valueOf(testerId));
			dList.setContent(content);
			dList.setComments(comments);
			dList.setCreateUserId(Integer.valueOf(createUserId));
			dList.setAppId(appId);
			dList.setDeliverType(deliverType);
			dList.setStatus(status);
			dList.setUpdateUserId(PP_UserDAO.getIdByUserName(updateUser));
			
			DeliverListDAO dListDAO = new DeliverListDAO();
			String result = dListDAO.updateDeliverList(dList);						
			if(result.contains("Success")){
				jO.put("status", "0");
				jO.put("message", "success");
				jsona.put(jO);	
				//return "success";
			}else{
				ServletActionContext.getRequest().setAttribute("errorMsg", result);
				jO.put("status", "1");
				jO.put("message", result);
				jsona.put(jO);	
				//return "error";
			}
		}else{
			jO.put("status", "2");
			jO.put("message", "Sorry! 您没有权限做该项操作。");
			jsona.put(jO);
		}
		try{
			ServletActionContext.getResponse().setHeader("content-type", "application/json");
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			ServletActionContext.getResponse().getWriter().write(jsona.toString());
		}catch(Exception e){
			e.printStackTrace();
		}		
	}	

	
	/*
	 * 删除发布单, pan.jing
	 * */
	public void deleteDeliverList(){
		String deliverId = ServletActionContext.getRequest().getParameter("deliverId");
		String updateUser = ServletActionContext.getRequest().getParameter("updateUser"); //删除者
		
/*		try {                                                             
			updateUser = new String(updateUser.getBytes("8859_1"), "utf8"); //调试：get方式请求将url中的中文转码为utf8
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}*/
		
		int userId  = PP_UserDAO.getIdByUserName(updateUser);
		int groupId = PP_UserDAO.getGroupIDByUserID(userId);
		boolean auth = false;
		auth = AuthorizationDAO.Authorization(groupId, userId); //权限
		
		JSONArray jsona=new JSONArray();
		JSONObject jO=new JSONObject();
		if(auth){
			DeliverListDAO dListDAO = new DeliverListDAO();	
			String result = dListDAO.deleteDeliverList(Integer.valueOf(deliverId));
			if(result.contains("Success")){
				jO.put("status", "0");
				jO.put("message", "success");
				jsona.put(jO);	
			}else{						
				ServletActionContext.getRequest().setAttribute("errorMsg", "删除失败！");
				jO.put("status", "1");
				jO.put("message", "删除失败！");
				jsona.put(jO);	
			}
		}else{
				jO.put("status", "2");
				jO.put("message", "Sorry! 您没有权限做该项操作。");
				jsona.put(jO);
		}			
		try{
			ServletActionContext.getResponse().setHeader("content-type", "application/json");
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			ServletActionContext.getResponse().getWriter().write(jsona.toString());
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	
	/*
	 * 查询发布单, pan.jing	
	 * */
	public void getDeliverLists(){
		String groupId = ServletActionContext.getRequest().getParameter("groupId"); 		
  		String startTime = ServletActionContext.getRequest().getParameter("startTime"); 
		String endTime = ServletActionContext.getRequest().getParameter("endTime");
		String status = ServletActionContext.getRequest().getParameter("status");

	try {                                                             
		groupId = new String(groupId.getBytes("8859_1"), "utf8"); //调试：get方式请求将url中的中文转码为utf8
		startTime = new String(startTime.getBytes("8859_1"), "utf8");
		endTime = new String(endTime.getBytes("8859_1"), "utf8");
		status = new String(status.getBytes("8859_1"), "utf8");				
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} 
	
		DeliverListDAO dListDAO = new DeliverListDAO();	
		JSONArray jArray = new JSONArray();
		jArray = dListDAO.queryDeliverLists(Integer.valueOf(groupId), startTime, endTime, status);
		try{
			ServletActionContext.getResponse().setHeader("content-type", "application/json");
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			ServletActionContext.getResponse().getWriter().write(jArray.toString());			
		 }catch(Exception e){
			ServletActionContext.getRequest().setAttribute("errorMsg", e.toString());
		 }					
	}
	
	
	
	

		
	
	
	
	
	
	
	
}

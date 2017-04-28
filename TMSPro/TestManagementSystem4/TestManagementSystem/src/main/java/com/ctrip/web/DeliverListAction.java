package com.ctrip.web;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.struts2.ServletActionContext;

import com.ctrip.DAO.AuthorizationDAO;
import com.ctrip.DAO.DeliverListDAO;
import com.ctrip.DAO.PP_UserDAO;
import com.ctrip.Model.DeliverList;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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
	try {                                                             
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
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		boolean auth = false;
		auth = AuthorizationDAO.Authorization(PP_UserDAO.getGroupIDByUserID(Integer.valueOf(groupId)), Integer.valueOf(PP_UserDAO.getIdByUserName(createUser))); //权限
		
		JSONArray jsona=new JSONArray();
		JSONObject jO=new JSONObject();
		if(auth){			
			DeliverList dList = new DeliverList();
			dList.setTitle(title);
			dList.setProjectId(Integer.valueOf(projectId)); 
			dList.setTaskId(Integer.valueOf(taskId));
			dList.setAppId(appId);
			dList.setDeliverType(deliverType);  //计划内为0，计划外为1
			dList.setDeveloperId(Integer.valueOf(developerId));
			dList.setTesterId(Integer.valueOf(testerId));
			dList.setStatus(status);
			dList.setDeliverNo(deliverNo);
			dList.setContent(content);
			dList.setComments(comments);
			dList.setCreateUserId(Integer.valueOf(PP_UserDAO.getIdByUserName(createUser)));
			
			DeliverListDAO dListDAO = new DeliverListDAO();				
			String result = dListDAO.insertDeliverList(dList);			
			if(result.contains("Success")){  
				jO.put("status", "0");
				jO.put("message", "success");
				jsona.add(jO);	
			}else{
				ServletActionContext.getRequest().setAttribute("errorMsg", result);
				jO.put("status", "1");
				jO.put("message", result);
				jsona.add(jO);	
			}
		}else{
			jO.put("status", "2");
			jO.put("message", "Sorry! 您没有权限做该项操作。");
			jsona.add(jO);
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
	 * */
	public void modifyDeliverList(){
	/*	String deliverId = ServletActionContext.getRequest().getParameter("deliverId");
//		String projectName = ServletActionContext.getRequest().getParameter("projectName");
		String taskName = ServletActionContext.getRequest().getParameter("taskName");
		String title = ServletActionContext.getRequest().getParameter("title");  
		String deliverNo = ServletActionContext.getRequest().getParameter("deliverNo");
		String developer = ServletActionContext.getRequest().getParameter("developer");
		String tester = ServletActionContext.getRequest().getParameter("tester");
		String applicationName = ServletActionContext.getRequest().getParameter("applicationName");
		String content = ServletActionContext.getRequest().getParameter("content");
		String comments = ServletActionContext.getRequest().getParameter("comments");
		String createUser = ServletActionContext.getRequest().getParameter("createUser");
		String updateUser = ServletActionContext.getRequest().getParameter("updateUser");
		
		int userId  = PP_UserDAO.getIdByUserName(updateUser);
		int groupId = PP_UserDAO.getGroupIDByUserID(userId);
		boolean auth = false;
		auth = AuthorizationDAO.Authorization(groupId, userId); //权限
		
		JSONArray jsona=new JSONArray();
		JSONObject jO=new JSONObject();
		if(auth){
			DeliverList dList = new DeliverList();
			DeliverListDAO dListDAO = new DeliverListDAO();					
			Map<String, Integer> map = dListDAO.queryProAndTaskId(taskName); //获取项目ID和任务ID
			dList.setId(Integer.valueOf(deliverId));
			dList.setProjectId(map.get("projectId")); 
			dList.setTaskId(map.get("taskId"));
			dList.setTitle(title);
			dList.setDeliverNo(deliverNo);
			dList.setDeveloper(PP_UserDAO.getIdByUserName(developer));
			dList.setTester(PP_UserDAO.getIdByUserName(tester));
			dList.setApplicationName(applicationName);
			dList.setContent(content);
			dList.setComments(comments);
			dList.setCreateUserId(PP_UserDAO.getIdByUserName(createUser));
			dList.setUpdateUserId(PP_UserDAO.getIdByUserName(updateUser));
			
			String result = dListDAO.updateDeliverList(dList);						
			if(result.contains("Success")){
				jO.put("status", "0");
				jO.put("message", "success");
				jsona.add(jO);	
				//return "success";
			}else{
				ServletActionContext.getRequest().setAttribute("errorMsg", result);
				jO.put("status", "1");
				jO.put("message", result);
				jsona.add(jO);	
				//return "error";
			}
		}else{
			jO.put("status", "2");
			jO.put("message", "Sorry! 您没有权限做该项操作。");
			jsona.add(jO);
		}
		try{
			ServletActionContext.getResponse().setHeader("content-type", "application/json");
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			ServletActionContext.getResponse().getWriter().write(jsona.toString());
		}catch(Exception e){
			e.printStackTrace();
		}		*/
	}	

	
	/*
	 * 删除发布单, pan.jing
	 * */
	public void deleteDeliverList(){
		String deliverId = ServletActionContext.getRequest().getParameter("deliverId");
		String updateUser = ServletActionContext.getRequest().getParameter("updateUser"); //删除者
		try {                                                             
			updateUser = new String(updateUser.getBytes("8859_1"), "utf8"); //调试：get方式请求将url中的中文转码为utf8
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		int userId  = PP_UserDAO.getIdByUserName(updateUser);
		int groupId = PP_UserDAO.getGroupIDByUserID(userId);
		boolean auth = false;
		auth = AuthorizationDAO.Authorization(groupId, userId); //权限
		
		JSONArray jsona=new JSONArray();
		JSONObject jO=new JSONObject();
		if(auth){
			DeliverList dList = new DeliverList();	
			DeliverListDAO dListDAO = new DeliverListDAO();	
			Boolean b = dListDAO.isExistId(Integer.valueOf(deliverId)); //判断id是否存在
			if(!b){
				ServletActionContext.getRequest().setAttribute("errorMsg", "deliverId不存在");
				jO.put("status", "1");
				jO.put("message", "deliverId不存在");
				jsona.add(jO);	
			}else{						
				dList.setId(Integer.valueOf(deliverId));			
				String result = dListDAO.deleteDeliverList(dList);						
				if(result.contains("Success")){
					jO.put("status", "0");
					jO.put("message", "success");
					jsona.add(jO);	
					//return "success";
				}else{
					ServletActionContext.getRequest().setAttribute("errorMsg", result);
					jO.put("status", "1");
					jO.put("message", result);
					jsona.add(jO);	
					//return "error";
				}
			}
		}else{
				jO.put("status", "2");
				jO.put("message", "Sorry! 您没有权限做该项操作。");
				jsona.add(jO);
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
		String departmentName = ServletActionContext.getRequest().getParameter("departmentName"); 
		String centerName = ServletActionContext.getRequest().getParameter("centerName"); 
		String groupName = ServletActionContext.getRequest().getParameter("groupName"); 		
//		String projectName = ServletActionContext.getRequest().getParameter("projectName"); 
		String startTime = ServletActionContext.getRequest().getParameter("startTime"); 
		String endTime = ServletActionContext.getRequest().getParameter("endTime");

		/*		try {                                                             
			departmentName = new String(departmentName.getBytes("8859_1"), "utf8"); //调试：get方式请求将url中的中文转码为utf8
			centerName = new String(centerName.getBytes("8859_1"), "utf8");
			groupName = new String(groupName.getBytes("8859_1"), "utf8");
			startTime = new String(startTime.getBytes("8859_1"), "utf8");
			endTime = new String(endTime.getBytes("8859_1"), "utf8");
			
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} */
		
		DeliverList dList2 = new DeliverList();
		dList2.setDepartmentName(departmentName);
		dList2.setCenterName(centerName);
		dList2.setGroupName(groupName);
		
		DeliverListDAO dListDAO = new DeliverListDAO();	
		List<DeliverList> lists = new ArrayList<DeliverList>();
		lists = dListDAO.queryDeliverLists(dList2, startTime, endTime);
		
		JSONArray jsona=new JSONArray();
		JSONObject jO=new JSONObject();
		if(lists.size() == 0){  
			ServletActionContext.getRequest().setAttribute("errorMsg", "未查询到数据");
			jO.put("status", "1");
			jO.put("message", "未查询到数据");
			jsona.add(jO);	
		}else{
			for (int i = 0; i < lists.size(); i++) {
				DeliverList dList = new DeliverList();
		        dList = lists.get(i);
		        jO.put("id", dList.getId()); 
		        jO.put("projectId", dList.getProjectId()); 
		        jO.put("taskId", dList.getTaskId()); 
		        jO.put("title", dList.getTitle()); 
		        jO.put("deliverNo", dList.getDeliverNo()); 
		        jO.put("developer", dList.getDeveloperId()); 
		        jO.put("tester", dList.getTesterId());        
//		        jO.put("applicationName", dList.getApplicationName()); 
		        jO.put("content", dList.getContent()); 
		        jO.put("comments", dList.getComments()); 
	            jO.put("createUserId", dList.getCreateUserId()); 
	            jO.put("updateUserId", dList.getUpdateUserId()); 
	            jO.put("createTime", dList.getCreateTime()); 
	            jO.put("updateTime", dList.getUpdateUserId()); 
	            jO.put("deliverType", dList.getDeliverType());
	            jO.put("appId", dList.getAppId());
	            jO.put("departmentName", dList.getDepartmentName());
	            jO.put("centerName", dList.getCenterName());
	            jO.put("groupName", dList.getGroupName());
	            jO.put("productName", dList.getProductName());	            
				jsona.add(jO);		         
			}
		}
		try
		{
			ServletActionContext.getResponse().setHeader("content-type", "application/json");
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			ServletActionContext.getResponse().getWriter().write(jsona.toString());			
		 }catch(Exception e){
			 ServletActionContext.getRequest().setAttribute("errorMsg", e.toString());
		 }			
		
	}
	
	
	
	

		
	
	
	
	
	
	
	
}

package com.ctrip.web;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsNull;

import com.ctrip.DAO.AuthorizationDAO;
import com.ctrip.DAO.DeliverListDAO;
import com.ctrip.DAO.PP_GroupDAO;
import com.ctrip.DAO.PP_UserDAO;
import com.ctrip.DAO.TaskDAO;
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
		String taskName = ServletActionContext.getRequest().getParameter("taskName");   //项目可以从任务表中获取
		String title = ServletActionContext.getRequest().getParameter("title");
		String deliverNo = ServletActionContext.getRequest().getParameter("deliverNo");
		String developer = ServletActionContext.getRequest().getParameter("developer");
		String tester = ServletActionContext.getRequest().getParameter("tester");
		String applicationName = ServletActionContext.getRequest().getParameter("applicationName");
		String content = ServletActionContext.getRequest().getParameter("content");
		String comments = ServletActionContext.getRequest().getParameter("comments");
		String createUser = ServletActionContext.getRequest().getParameter("createUser");

		int userId  = PP_UserDAO.getIdByUserName(createUser);
		int groupId = PP_UserDAO.getGroupIDByUserID(userId);
		boolean auth = false;
		auth = AuthorizationDAO.Authorization(groupId, userId); //权限
		
		JSONArray jsona=new JSONArray();
		JSONObject jO=new JSONObject();
		if(auth){
			DeliverList dList = new DeliverList();
			DeliverListDAO dListDAO = new DeliverListDAO();	
			Map<String, Integer> map = dListDAO.queryProAndTaskId(taskName);	//根据任务名称获取项目Id和任务Id
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
			dList.setUpdateUserId(PP_UserDAO.getIdByUserName(createUser));	//初始创建updateUser = createUser
			
			String result = dListDAO.insertDeliverList(dList);			
			if(result.contains("Success")){  //返回操作结果
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
		String deliverId = ServletActionContext.getRequest().getParameter("deliverId");
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
		}		
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
	
	
	public void getDeliverList(){
		String deliverId = ServletActionContext.getRequest().getParameter("deliverId");
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
		String createTime = ServletActionContext.getRequest().getParameter("createTime");
		String endTime = ServletActionContext.getRequest().getParameter("endTime");
		
	    String sql = "select *  from  ProcessPlatform..DeliverList where 1 = 1 "; 
	    if (Integer.valueOf(deliverId) != 0) {
	        sql = sql + "and Id = ?";
	    }
	    if (taskName != null) {
	        sql = sql + "and taskName = ?";
	    }
	  
	    return map;       
	}

	
	
	
	

	
	
	/*
	 * 根据groupName查询小组所有发布单, pan.jing	
	 * */
	public void getDeliverListsByGroup()  {
		String groupName = ServletActionContext.getRequest().getParameter("groupName");
		
		try {                                                             
			groupName = new String(groupName.getBytes("8859_1"), "utf8"); //调试：get方式请求将url中的中文转码为utf8
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} 
		List<DeliverList> lists = new ArrayList<DeliverList>();
		DeliverList dList = new DeliverList();
		JSONArray jsona=new JSONArray();
		JSONObject jO=new JSONObject();

		DeliverListDAO dListDAO = new DeliverListDAO();	
		lists = dListDAO.queryDeliverListsByGroup(groupName);		
		if(lists.size() == 0){  
			ServletActionContext.getRequest().setAttribute("errorMsg", "未查询到数据");
			jO.put("status", "1");
			jO.put("message", "未查询到数据");
			jsona.add(jO);	
		}else{
			for (int i = 0; i < lists.size(); i++) {
		        dList = lists.get(i);
		        jO.put("id", dList.getId()); 
		        jO.put("projectId", dList.getProjectId()); 
		        jO.put("taskId", dList.getTaskId()); 
		        jO.put("title", dList.getTitle()); 
		        jO.put("deliverNo", dList.getDeliverNo()); 
		        jO.put("developer", dList.getDeveloper()); 
		        jO.put("tester", dList.getTester());        
		        jO.put("applicationName", dList.getApplicationName()); 
		        jO.put("content", dList.getContent()); 
		        jO.put("comments", dList.getComments()); 
	            jO.put("createUserId", dList.getCreateUserId()); 
	            jO.put("updateUserId", dList.getUpdateUserId()); 
	            jO.put("createTime", dList.getCreateTime()); 
	            jO.put("updateTime", dList.getUpdateUserId()); 
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

		
	
	/*
	 * 根据centerName查询所有发布单, pan.jing
	 * */	
	public void getDeliverListsByCenter() {
		String centerName = ServletActionContext.getRequest().getParameter("centerName");
		/*
		try {                                                             
			groupName = new String(groupName.getBytes("8859_1"), "utf8"); //调试：get方式请求将url中的中文转码为utf8
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} */
		List<DeliverList> lists = new ArrayList<DeliverList>();		
		DeliverListDAO dListDAO = new DeliverListDAO();	
		lists = dListDAO.queryDeliverListsByCenter(centerName);
		DeliverList dList = new DeliverList();
		JSONArray jsona=new JSONArray();
		JSONObject jO=new JSONObject();
		if(lists.size() == 0){  
			ServletActionContext.getRequest().setAttribute("errorMsg", "未查询到数据");
			jO.put("status", "1");
			jO.put("message", "未查询到数据");
			jsona.add(jO);	
		}else{
			for (int i = 0; i < lists.size(); i++) {
		        dList = lists.get(i);
		        jO.put("id", dList.getId()); 
		        jO.put("projectId", dList.getProjectId()); 
		        jO.put("taskId", dList.getTaskId());
		        jO.put("title", dList.getTitle());
		        jO.put("deliverNo", dList.getDeliverNo());
		        jO.put("developer", dList.getDeveloper());
		        jO.put("tester", dList.getTester());          
		        jO.put("applicationName", dList.getApplicationName()); 
		        jO.put("content", dList.getContent()); 
		        jO.put("comments", dList.getComments()); 
	            jO.put("createUserId", dList.getCreateUserId()); 
	            jO.put("updateUserId", dList.getUpdateUserId()); 
	            jO.put("createTime", dList.getCreateTime()); 
	            jO.put("updateTime", dList.getUpdateUserId()); 
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
	
	
	/*
	 * 根据Date查询一段时间的发布单, pan.jing
	 * */
	public void getDeliverListsByDate(){
		String startTime = ServletActionContext.getRequest().getParameter("startTime");	
		String endTime = ServletActionContext.getRequest().getParameter("endTime");		
		
		List<DeliverList> lists = new ArrayList<DeliverList>();	
		DeliverListDAO dListDAO = new DeliverListDAO();	
		lists = dListDAO.queryDeliverListsByDate(startTime,endTime);
		DeliverList dList = new DeliverList();
		JSONArray jsona=new JSONArray();
		JSONObject jO=new JSONObject();
		if(lists.size() == 0){  
			ServletActionContext.getRequest().setAttribute("errorMsg", "未查询到数据");
			jO.put("status", "1");
			jO.put("message", "未查询到数据");
			jsona.add(jO);	
		}else{
			for (int i = 0; i < lists.size(); i++) {
		        dList = lists.get(i);
		        jO.put("id", dList.getId()); 
		        jO.put("projectId", dList.getProjectId()); 
		        jO.put("taskId", dList.getTaskId()); 
		        jO.put("title", dList.getTitle()); 
		        jO.put("deliverNo", dList.getDeliverNo()); 
		        jO.put("developer", dList.getDeveloper()); 
		        jO.put("tester", dList.getTester());        
		        jO.put("applicationName", dList.getApplicationName()); 
		        jO.put("content", dList.getContent()); 
		        jO.put("comments", dList.getComments()); 
	            jO.put("createUserId", dList.getCreateUserId()); 
	            jO.put("updateUserId", dList.getUpdateUserId()); 
	            jO.put("createTime", dList.getCreateTime()); 
	            jO.put("updateTime", dList.getUpdateUserId()); 
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
	
	
	/*
	 * 根据发布单id查询发布单详细信息,查询不需要判断权限,pan.jing
	 * */	
	public void getDeliverListById() {
		String deliverId = ServletActionContext.getRequest().getParameter("deliverId");		
		DeliverListDAO dListDAO = new DeliverListDAO();	
		JSONArray jsona=new JSONArray();
		JSONObject jO=new JSONObject();
		Boolean exist = false;
		exist = dListDAO.isExistId(Integer.valueOf(deliverId));  //判断Id是否存在
		if(!exist){
			ServletActionContext.getRequest().setAttribute("errorMsg", "deliverId不存在");
			jO.put("status", "1");
			jO.put("message", "deliverId不存在");
			jsona.add(jO);	
			
		}else{
			DeliverList dList = dListDAO.queryDeliverInfoById(Integer.valueOf(deliverId));
			if(dList != null){
				jO.put("id", dList.getId()); 
		        jO.put("projectId", dList.getProjectId()); 
		        jO.put("taskId", dList.getTaskId());
		        jO.put("title", dList.getTitle());
		        jO.put("deliverNo", dList.getDeliverNo());
		        jO.put("developer", dList.getDeveloper());
		        jO.put("tester", dList.getTester());          
		        jO.put("applicationName", dList.getApplicationName()); 
		        jO.put("content", dList.getContent()); 
		        jO.put("comments", dList.getComments()); 
	            jO.put("createUserId", dList.getCreateUserId()); 
	            jO.put("updateUserId", dList.getUpdateUserId()); 
	            jO.put("createTime", dList.getCreateTime()); 
	            jO.put("updateTime", dList.getUpdateUserId()); 
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

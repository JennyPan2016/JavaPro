package com.ctrip.web;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.ctrip.DAO.DeliverListDAO;
import com.ctrip.Model.DeliverList;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class DeliverListAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;

	//添加一个发布单,pan.jing
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

		JSONArray jsona=new JSONArray();
		JSONObject jO=new JSONObject();
		if(true){
			DeliverList dList = new DeliverList();
			DeliverListDAO dListDAO = new DeliverListDAO();	
			Map<String, Integer> map = dListDAO.getProAndTaskId(taskName);	//根据任务名称获取项目Id和任务Id
			dList.setProjectId(map.get("projectId")); 
			dList.setTaskId(map.get("taskId"));
			dList.setTitle(title);
			dList.setDeliverNo(deliverNo);
			dList.setDeveloper(dListDAO.getUserIdByName(developer));
			dList.setTester(dListDAO.getUserIdByName(tester));
			dList.setApplicationName(applicationName);
			dList.setContent(content);
			dList.setComments(comments);
			dList.setCreateUserId(dListDAO.getUserIdByName(createUser));
			dList.setUpdateUserId(dListDAO.getUserIdByName(createUser));	//初始创建updateUser = createUser
			
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

	
	//更新发布单内容,pan.jing
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
		String updateUser = (String) ServletActionContext.getRequest().getSession().getAttribute("updateUser");
		
		JSONArray jsona=new JSONArray();
		JSONObject jO=new JSONObject();
		if(true){
			DeliverList dList = new DeliverList();
			DeliverListDAO dListDAO = new DeliverListDAO();					
			Map<String, Integer> map = dListDAO.getProAndTaskId(taskName); //获取项目ID和任务ID
			dList.setId(Integer.valueOf(deliverId));
			dList.setProjectId(map.get("projectId")); 
			dList.setTaskId(map.get("taskId"));
			dList.setTitle(title);
			dList.setDeliverNo(deliverNo);
			dList.setDeveloper(dListDAO.getUserIdByName(developer));
			dList.setTester(dListDAO.getUserIdByName(tester));
			dList.setApplicationName(applicationName);
			dList.setContent(content);
			dList.setComments(comments);
			dList.setCreateUserId(dListDAO.getUserIdByName(createUser));
			dList.setUpdateUserId(dListDAO.getUserIdByName(updateUser));
			
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


	//根据groupName查询小组所有发布单, pan.jing	
	public void getdeliverListByGroup()  {
		String groupName = ServletActionContext.getRequest().getParameter("groupName");
		/*
		try {                                                             
			groupName = new String(groupName.getBytes("8859_1"), "utf8"); //调试：get方式请求将url中的中文转码为utf8
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} */
		List<DeliverList> lists = new ArrayList<DeliverList>();
		DeliverList dList = new DeliverList();
		JSONArray jsona=new JSONArray();
		JSONObject jO=new JSONObject();
		
		if(true){
			DeliverListDAO dListDAO = new DeliverListDAO();	
			lists = dListDAO.queryDeliverListByGroup(groupName);		
			if(lists.size() == 0){  
				ServletActionContext.getRequest().setAttribute("errorMsg", "未查询到数据");
				jO.put("status", "1");
				jO.put("message", "未查询到数据");
				jsona.add(jO);	
			}else{
				for (int i = 0; i < lists.size(); i++) {
			        dList = lists.get(i);
			        jO.put("id", dList.getId()); //发布单ID
			        jO.put("projectId", dList.getProjectId()); //项目ID
			        jO.put("taskId", dList.getTaskId()); //任务ID
			        jO.put("title", dList.getTitle()); //发布单标题
			        jO.put("deliverNo", dList.getDeliverNo()); //发布单号
			        jO.put("developer", dList.getDeveloper()); //开发
			        jO.put("tester", dList.getTester()); //测试               
			        jO.put("applicationName", dList.getApplicationName()); //应用名称
			        jO.put("content", dList.getContent()); //发布内容
			        jO.put("comments", dList.getComments()); //备注   
		            jO.put("createUserId", dList.getCreateUserId()); //创建者
		            jO.put("updateUserId", dList.getUpdateUserId()); //更新者
		            jO.put("createTime", dList.getCreateTime()); //创建时间
		            jO.put("updateTime", dList.getUpdateUserId()); //更新时间
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

	
	//根据centerName查询所有发布单, pan.jing
	public void getdeliverListByCenter() {
		String centerName = ServletActionContext.getRequest().getParameter("centerName");
		/*
		try {                                                             
			groupName = new String(groupName.getBytes("8859_1"), "utf8"); //调试：get方式请求将url中的中文转码为utf8
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} */
		List<DeliverList> lists = new ArrayList<DeliverList>();
		DeliverList dList = new DeliverList();
		JSONArray jsona=new JSONArray();
		JSONObject jO=new JSONObject();
		
		if(true){
			DeliverListDAO dListDAO = new DeliverListDAO();	
			lists = dListDAO.queryDeliverListByCenter(centerName);		
			if(lists.size() == 0){  
				ServletActionContext.getRequest().setAttribute("errorMsg", "未查询到数据");
				jO.put("status", "1");
				jO.put("message", "未查询到数据");
				jsona.add(jO);	
			}else{
				for (int i = 0; i < lists.size(); i++) {
			        dList = lists.get(i);
			        jO.put("id", dList.getId()); //发布单ID
			        jO.put("projectId", dList.getProjectId()); //项目ID
			        jO.put("taskId", dList.getTaskId()); //任务ID
			        jO.put("title", dList.getTitle()); //发布单标题
			        jO.put("deliverNo", dList.getDeliverNo()); //发布单号
			        jO.put("developer", dList.getDeveloper()); //开发
			        jO.put("tester", dList.getTester()); //测试               
			        jO.put("applicationName", dList.getApplicationName()); //应用名称
			        jO.put("content", dList.getContent()); //发布内容
			        jO.put("comments", dList.getComments()); //备注   
		            jO.put("createUserId", dList.getCreateUserId()); //创建者
		            jO.put("updateUserId", dList.getUpdateUserId()); //更新者
		            jO.put("createTime", dList.getCreateTime()); //创建时间
		            jO.put("updateTime", dList.getUpdateUserId()); //更新时间
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
	
	
	
	//根据发布单id查询发布单详细信息，返回每一条发布单所有信息给前端
	
	//获取权限 传入Department Center PP_Group  Product userName

}

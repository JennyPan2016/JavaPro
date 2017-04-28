package com.ctrip.web;

import com.ctrip.DAO.BaseQueryDAO;
import com.ctrip.Model.BaseQuery;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;

import java.util.ArrayList;
import java.util.List;

public class BaseQueryAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	/*
	 * 查询所有Department，pan.jing
	 * */		
	public void getAllDepartment(){
		List<BaseQuery> list = new ArrayList<BaseQuery>();
		BaseQueryDAO bQueryDAO = new BaseQueryDAO();
		list = bQueryDAO.queryAllDepartment();
		
		JSONArray jsona=new JSONArray();
		JSONObject jO=new JSONObject();
		if(list.size() == 0){  
			ServletActionContext.getRequest().setAttribute("errorMsg", "未查询到数据");
			jO.put("status", "1");
			jO.put("message", "未查询到数据");
			jsona.add(jO);	
		}else{
			for (int i = 0; i < list.size(); i++) {
			BaseQuery bQuery = new BaseQuery();
			bQuery = list.get(i);
	        jO.put("departmentId",bQuery.getDepartmentId());
	        jO.put("departmentName", bQuery.getDepartmentName());
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
	 * 查询所有Center，pan.jing
	 * */	
	public void getAllCenter(){
		String departmentId = ServletActionContext.getRequest().getParameter("departmentId");
		
		List<BaseQuery> list = new ArrayList<BaseQuery>();
		BaseQueryDAO bQueryDAO = new BaseQueryDAO();
		list = bQueryDAO.queryAllCenter(Integer.valueOf(departmentId));
		
		JSONArray jsona=new JSONArray();
		JSONObject jO=new JSONObject();
		if(list.size() == 0){  
			ServletActionContext.getRequest().setAttribute("errorMsg", "未查询到数据");
			jO.put("status", "1");
			jO.put("message", "未查询到数据");
			jsona.add(jO);	
		}else{
			for (int i = 0; i < list.size(); i++) {
			BaseQuery bQuery = new BaseQuery();
			bQuery = list.get(i);
			jO.put("centerId", bQuery.getCenterId());
	        jO.put("centerName", bQuery.getCenterName()); 
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
	 * 查询所有group，pan.jing
	 * */	
	public void getAllGroup(){	
		String departmentId = ServletActionContext.getRequest().getParameter("departmentId");
		String centerId = ServletActionContext.getRequest().getParameter("centerId");
		
		List<BaseQuery> list = new ArrayList<BaseQuery>();
		BaseQueryDAO bQueryDAO = new BaseQueryDAO();
		list = bQueryDAO.queryAllGroup(Integer.valueOf(departmentId),Integer.valueOf(centerId));
		
		JSONArray jsona=new JSONArray();
		JSONObject jO=new JSONObject();
		if(list.size() == 0){  
			ServletActionContext.getRequest().setAttribute("errorMsg", "未查询到数据");
			jO.put("status", "1");
			jO.put("message", "未查询到数据");
			jsona.add(jO);	
		}else{
			for (int i = 0; i < list.size(); i++) {
			BaseQuery bQuery = new BaseQuery();
			bQuery = list.get(i);
			jO.put("groupId", bQuery.getGroupId());
	        jO.put("groupName", bQuery.getGroupName());
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
	 * 查询所有Product，pan.jing
	 * */		
	public void getAllProduct(){	
		String departmentId = ServletActionContext.getRequest().getParameter("departmentId");
		String centerId = ServletActionContext.getRequest().getParameter("centerId");
		String groupId = ServletActionContext.getRequest().getParameter("groupId");
					
		List<BaseQuery> list = new ArrayList<BaseQuery>();
		BaseQueryDAO bQueryDAO = new BaseQueryDAO();
		list = bQueryDAO.queryAllProduct(Integer.valueOf(departmentId),Integer.valueOf(centerId),Integer.valueOf(groupId));
		
		JSONArray jsona=new JSONArray();
		JSONObject jO=new JSONObject();
		if(list.size() == 0){  
			ServletActionContext.getRequest().setAttribute("errorMsg", "未查询到数据");
			jO.put("status", "1");
			jO.put("message", "未查询到数据");
			jsona.add(jO);	
		}else{
			for (int i = 0; i < list.size(); i++) {
			BaseQuery bQuery = new BaseQuery();
			bQuery = list.get(i);
			jO.put("productId", bQuery.getProductId());
	        jO.put("productName", bQuery.getProductName()); 
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
	 * 查询所有Project，pan.jing
	 * */		
	public void getAllProject(){	
		String centerId = ServletActionContext.getRequest().getParameter("centerId");
		String groupId = ServletActionContext.getRequest().getParameter("groupId");
		String productId = ServletActionContext.getRequest().getParameter("productId");	
		
		List<BaseQuery> list = new ArrayList<BaseQuery>();
		BaseQueryDAO bQueryDAO = new BaseQueryDAO();
		list = bQueryDAO.queryAllProject(Integer.valueOf(centerId),Integer.valueOf(groupId),Integer.valueOf(productId));
		
		JSONArray jsona=new JSONArray();
		JSONObject jO=new JSONObject();
		if(list.size() == 0){  
			ServletActionContext.getRequest().setAttribute("errorMsg", "未查询到数据");
			jO.put("status", "1");
			jO.put("message", "未查询到数据");
			jsona.add(jO);	
		}else{
			for (int i = 0; i < list.size(); i++) {
			BaseQuery bQuery = new BaseQuery();
			bQuery = list.get(i);
			jO.put("projectId", bQuery.getProjectId());
	        jO.put("projectName", bQuery.getProjectName()); 
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
	 * 查询所有Task，pan.jing
	 * */		
	public void getAllTask(){	
		String projectId = ServletActionContext.getRequest().getParameter("projectId");
		
		List<BaseQuery> list = new ArrayList<BaseQuery>();
		BaseQueryDAO bQueryDAO = new BaseQueryDAO();
		list = bQueryDAO.queryAllTask(Integer.valueOf(projectId));
		
		JSONArray jsona=new JSONArray();
		JSONObject jO=new JSONObject();
		if(list.size() == 0){  
			ServletActionContext.getRequest().setAttribute("errorMsg", "未查询到数据");
			jO.put("status", "1");
			jO.put("message", "未查询到数据");
			jsona.add(jO);	
		}else{
			for (int i = 0; i < list.size(); i++) {
			BaseQuery bQuery = new BaseQuery();
			bQuery = list.get(i);
			jO.put("taskId", bQuery.getTaskId());
	        jO.put("taskName", bQuery.getTaskName()); 
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

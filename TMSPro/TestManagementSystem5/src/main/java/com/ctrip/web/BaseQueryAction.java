package com.ctrip.web;

import com.ctrip.DAO.BaseQueryDAO;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;

public class BaseQueryAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	/*
	 * 查询所有Department，pan.jing
	 * */		
	public void getAllDepartment(){
		JSONArray jsona = new JSONArray();
		BaseQueryDAO bQueryDAO = new BaseQueryDAO();
		jsona = bQueryDAO.queryAllDepartment();
		
		try {
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
		
		JSONArray jsona = new JSONArray();
		BaseQueryDAO bQueryDAO = new BaseQueryDAO();
		jsona = bQueryDAO.queryAllCenter(Integer.valueOf(departmentId));
		
		try {
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
		String centerId = ServletActionContext.getRequest().getParameter("centerId");
		
		JSONArray jsona = new JSONArray();
		BaseQueryDAO bQueryDAO = new BaseQueryDAO();
		jsona = bQueryDAO.queryAllGroup(Integer.valueOf(centerId));
		
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
		String groupId = ServletActionContext.getRequest().getParameter("groupId");
					
		JSONArray jsona = new JSONArray();
		BaseQueryDAO bQueryDAO = new BaseQueryDAO();
		jsona = bQueryDAO.queryAllProduct(Integer.valueOf(groupId));
		
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
		String productId = ServletActionContext.getRequest().getParameter("productId");	
		
		JSONArray jsona = new JSONArray();
		BaseQueryDAO bQueryDAO = new BaseQueryDAO();
		jsona = bQueryDAO.queryAllProject(Integer.valueOf(productId));
		
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
		
		JSONArray jsona = new JSONArray();
		BaseQueryDAO bQueryDAO = new BaseQueryDAO();
		jsona = bQueryDAO.queryAllTask(Integer.valueOf(projectId));
		
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

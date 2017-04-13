package com.ctrip.Web;
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
		String status = null;  //权限
		
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
		
		JSONArray jsona=new JSONArray();
		JSONObject jO=new JSONObject();
		if(result.contains("Success")){  //返回操作结果
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
		JSONArray jsona=new JSONArray();
		JSONObject jO=new JSONObject();
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
		try{
			ServletActionContext.getResponse().setHeader("content-type", "application/json");
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			ServletActionContext.getResponse().getWriter().write(jsona.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
	}	


	//根据组别查询发布单列表，返回每一条发布单所有信息给前端
	public String DeliverListByGroupId(String group){
		
		
		
		
		
		return group;
		
	}
	
	
	
	//根据发布单id查询发布单详细信息，返回每一条发布单所有信息给前端
	
	//获取权限 传入Department Center PP_Group  Product userName

}

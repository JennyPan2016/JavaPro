package com.ctrip.web;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;

import com.ctrip.DAO.CenterDAO;
import com.ctrip.DAO.PP_GroupDAO;
import com.ctrip.DAO.PP_UserDAO;
import com.ctrip.DAO.ProductDAO;
import com.ctrip.DAO.RollBackInfoDAO;
import com.ctrip.Model.RollBackInfo;

public class RollBackInfoAction {

	public void addRollBackInfo(){
		//String department=ServletActionContext.getRequest().getParameter("department");//暂时只有基础业务
		String center=ServletActionContext.getRequest().getParameter("center");
		String groupName=ServletActionContext.getRequest().getParameter("groupName");
		String productName=ServletActionContext.getRequest().getParameter("productName");
		String roleuser=ServletActionContext.getRequest().getParameter("roleuser");
		String rollbackType=ServletActionContext.getRequest().getParameter("rollbackType");
		String ropid=ServletActionContext.getRequest().getParameter("ropid");
		String releaseVersion=ServletActionContext.getRequest().getParameter("releaseVersion");
		String startTime=ServletActionContext.getRequest().getParameter("startTime");
		String endTime=ServletActionContext.getRequest().getParameter("endTime");
		String rollbackReason=ServletActionContext.getRequest().getParameter("rollbackReason");
		String developer=ServletActionContext.getRequest().getParameter("developer");
		String tester=ServletActionContext.getRequest().getParameter("tester");
		String backCategory=ServletActionContext.getRequest().getParameter("backCategory");
		String backGroup=ServletActionContext.getRequest().getParameter("backGroup");
		String description=ServletActionContext.getRequest().getParameter("description");
		String createUser=ServletActionContext.getRequest().getParameter("createUser");
		String updateUser=ServletActionContext.getRequest().getParameter("updateUser");
		
		JSONArray jsona = new JSONArray();
		JSONObject jo = new JSONObject();
		String result="";//0 Success,1 Fail,2 no access
		Boolean role=false;
		//role=Authorization(department,center,groupName,roleuser);
		if(role){
		
			RollBackInfoDAO rollBackInfoDao=new RollBackInfoDAO();
			
			Integer departmentId=1;//暂时只有基础业务
			Integer centerId=(new CenterDAO()).getIdByCenter(center);
			Integer groupId=(new PP_GroupDAO()).getIdByGroup(groupName);
			Integer productId=(new ProductDAO()).getIdByProduct(productName);
			Integer developerId=(new PP_UserDAO()).getIdByUserName(developer);
			Integer testerId=(new PP_UserDAO()).getIdByUserName(tester);
			Integer backCategoryId=rollBackInfoDao.getIdByBackCategory(backCategory);
			Integer backGroupId=rollBackInfoDao.getIdByBackGroup(backGroup);
			Integer createUserId=(new PP_UserDAO()).getIdByUserName(createUser);
			Integer updateUserId=(new PP_UserDAO()).getIdByUserName(updateUser);
			
			RollBackInfo rollBackInfo=new RollBackInfo();
			rollBackInfo.setDepartmentId(departmentId);
			rollBackInfo.setCenterId(centerId);
			rollBackInfo.setGroupId(groupId);
			rollBackInfo.setProductId(productId);
			rollBackInfo.setDeveloperId(developerId);
			rollBackInfo.setTesterId(testerId);
			rollBackInfo.setBackCategoryId(backCategoryId);
			rollBackInfo.setBackGroupId(backGroupId);
			rollBackInfo.setCreateUserId(createUserId);
			rollBackInfo.setUpdateUserId(updateUserId);
			rollBackInfo.setRollbackType(rollbackType);
			rollBackInfo.setRopid(ropid);
			rollBackInfo.setReleaseVersion(releaseVersion);
			rollBackInfo.setStartTime(startTime);
			rollBackInfo.setEndTime(endTime);
			rollBackInfo.setRollbackReason(rollbackReason);
			rollBackInfo.setDescription(description);
		
			result=rollBackInfoDao.addRollBackInfo(rollBackInfo);
			
			if (result.contains("Success")){
				jo.put("status", "0");
				jo.put("message", "success");
				jsona.put(jo);
			}else{
				ServletActionContext.getRequest().setAttribute("errorMsg", result);
				jo.put("status", "1");
				jo.put("message", result);
				jsona.put(jo);
			}
		}else{
			jo.put("status", "2");
			jo.put("message", "Sorry! 您没有权限新增!");
			jsona.put(jo);
		}
		try{
			ServletActionContext.getResponse().setHeader("content-type", "application/json");
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			ServletActionContext.getResponse().getWriter().write(jsona.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

package com.ctrip.web;
import java.io.File;
import java.util.List;
import java.lang.Boolean;

import jxl.Workbook;
import jxl.write.*;
import jxl.write.Number;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;

import com.ctrip.DAO.AuthorizationDAO;
import com.ctrip.DAO.CenterDAO;
import com.ctrip.DAO.PP_GroupDAO;
import com.ctrip.DAO.PP_UserDAO;
import com.ctrip.DAO.ProductDAO;
import com.ctrip.DAO.UrgentReleaseInfoDAO;
import com.ctrip.Model.UrgentReleaseInfo;


/*
 * Created by fzhuang
 * 2017/04/21
*/

public class UrgentReleaseInfoAction {

	public void addUrgentReleaseInfo(){
		//String department=ServletActionContext.getRequest().getParameter("department");//暂时只有基础业务
		String center=ServletActionContext.getRequest().getParameter("center");
		String groupName=ServletActionContext.getRequest().getParameter("groupName");
		String productName=ServletActionContext.getRequest().getParameter("productName");
		String roleuser=ServletActionContext.getRequest().getParameter("roleuser");
		String appid=ServletActionContext.getRequest().getParameter("appid");
		String releaseType=ServletActionContext.getRequest().getParameter("releaseType");
		String applicant=ServletActionContext.getRequest().getParameter("applicant");
		String appliedTime=ServletActionContext.getRequest().getParameter("appliedTime");
		String developer=ServletActionContext.getRequest().getParameter("developer");
		String tester=ServletActionContext.getRequest().getParameter("tester");
		String reason=ServletActionContext.getRequest().getParameter("reason");
		String risk=ServletActionContext.getRequest().getParameter("risk");
		String releaseVersion=ServletActionContext.getRequest().getParameter("releaseVersion");
		String description=ServletActionContext.getRequest().getParameter("description");
		String createUser=roleuser;
		String updateUser=ServletActionContext.getRequest().getParameter("updateUser");
		String releaseFinishedTime = ServletActionContext.getRequest().getParameter("releaseFinishedTime");
		
		JSONArray jsona = new JSONArray();
		JSONObject jo = new JSONObject();
		String result="";//0 Success,1 Fail,2 no access
		Boolean role=false;
		//role=Authorization(department,  center,  groupName,  roleuser);
		if(role){
		
			UrgentReleaseInfoDAO urgentReleaseInfoDAO = new UrgentReleaseInfoDAO();
			
			Integer departmentId=1;//暂时只有基础业务
			Integer centerId=CenterDAO.getIdByCenter(center);
			Integer groupId=PP_GroupDAO.getIdByGroup(groupName);
			Integer productId=ProductDAO.getIdByProduct(productName);
			Integer developerId=PP_UserDAO.getIdByUserName(developer);
			Integer testerId=PP_UserDAO.getIdByUserName(tester);
			Integer applicantId=PP_UserDAO.getIdByUserName(applicant);
			Integer createUserId=PP_UserDAO.getIdByUserName(createUser);
			Integer updateUserId=PP_UserDAO.getIdByUserName(updateUser);
			
			UrgentReleaseInfo urgentReleaseInfo = new UrgentReleaseInfo();
			urgentReleaseInfo.setReleaseType(releaseType);
			urgentReleaseInfo.setAppid(appid);
			urgentReleaseInfo.setApplicant(applicantId);
			urgentReleaseInfo.setDepartmentId(departmentId);
			urgentReleaseInfo.setCenterId(centerId);
			urgentReleaseInfo.setGroupId(groupId);
			urgentReleaseInfo.setProductId(productId);
			urgentReleaseInfo.setAppliedTime(appliedTime);
			urgentReleaseInfo.setUrgentReleaseReason(reason);
			urgentReleaseInfo.setDeveloperId(developerId);
			urgentReleaseInfo.setTesterId(testerId);
			urgentReleaseInfo.setReleaseRisk(risk);
			urgentReleaseInfo.setReleaseVersion(releaseVersion);
			urgentReleaseInfo.setDescription(description);
			urgentReleaseInfo.setCreateUserId(createUserId);
			urgentReleaseInfo.setUpdateUserId(updateUserId);
			urgentReleaseInfo.setReleaseFinishedTime(releaseFinishedTime);
			
		
			result = urgentReleaseInfoDAO.addUrgentReleaseInfo(urgentReleaseInfo);
			
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
	
	public void deleteUrgentReleaseInfo() {
		String idString = ServletActionContext.getRequest().getParameter("id");
		String department=ServletActionContext.getRequest().getParameter("department");//暂时只有基础业务
		String center=ServletActionContext.getRequest().getParameter("center");
		String groupName=ServletActionContext.getRequest().getParameter("groupName");
		//String productName=ServletActionContext.getRequest().getParameter("productName");
		String roleuser=ServletActionContext.getRequest().getParameter("roleuser");
		String updateUser=roleuser;
		
		JSONArray jsona = new JSONArray();
		JSONObject jo = new JSONObject();
		String result="";//0 Success,1 Fail,2 no access
		Boolean role=false;
		role=AuthorizationDAO.Authorization(department,  center,  groupName,  roleuser);
		
		if(role) {
			UrgentReleaseInfoDAO urgentReleaseInfoDAO = new UrgentReleaseInfoDAO();
			
			Integer id = Integer.parseInt(idString);
			Integer updateUserId=PP_UserDAO.getIdByUserName(updateUser);
			
			UrgentReleaseInfo info = new UrgentReleaseInfo();
			info.setId(id);
			info.setUpdateUserId(updateUserId);
			
			result = urgentReleaseInfoDAO.deleteInfoById(info);
			
			if (result.contains("Success")) {
				jo.put("status", "0");
				jo.put("message", "success");
				jsona.put(jo);
			}else {
				ServletActionContext.getRequest().setAttribute("errorMsg", result);
				jo.put("status", "1");
				jo.put("message", result);
				jsona.put(jo);
			}
		}else {
			jo.put("status", "2");
			jo.put("message", "Sorry! 您没有权限新增!");
			jsona.put(jo);
		}
		
		try {
			ServletActionContext.getResponse().setHeader("content-type", "application/json");
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			ServletActionContext.getResponse().getWriter().write(jsona.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getUrgentReleaseInfo() {
		String startTime = ServletActionContext.getRequest().getParameter("startTime");
		String endTime = ServletActionContext.getRequest().getParameter("endTime");
		String groupName = ServletActionContext.getRequest().getParameter("groupName");
		String productName = ServletActionContext.getRequest().getParameter("productName");
		String releaseType = ServletActionContext.getRequest().getParameter("releaseType");
		String releaseVersion = ServletActionContext.getRequest().getParameter("releaseVersion");
		
		Integer groupId = PP_GroupDAO.getIdByGroup(groupName);
		Integer productId = ProductDAO.getIdByProduct(productName);
		
		UrgentReleaseInfo info = new UrgentReleaseInfo();
		info.setStartTime(startTime);
		info.setEndTime(endTime);
		info.setGroupId(groupId);
		info.setProductId(productId);
		info.setReleaseType(releaseType);
		info.setReleaseVersion(releaseVersion);
		
		UrgentReleaseInfoDAO urInfoDAO = new UrgentReleaseInfoDAO();
		try {
			List<UrgentReleaseInfo> list = urInfoDAO.getUrgentReleaseInfo(info);
			JSONArray jsona = new JSONArray();
			for(UrgentReleaseInfo urInfo:list) {
				JSONObject jo = new JSONObject();
				jo.put("id", urInfo.getId());
				jo.put("ProductName", urInfo.getProductName());
				jo.put("Appid", urInfo.getAppid());
				jo.put("UrgentReleaseType", urInfo.getReleaseType());
				jo.put("Applicant", urInfo.getApplicantName());
				jo.put("AppliedTime", urInfo.getAppliedTime());
				jo.put("Developer", urInfo.getDeveloper());
				jo.put("Tester", urInfo.getTester());
				jo.put("ReleaseReason", urInfo.getUrgentReleaseReason());
				jo.put("ReleaseRisk", urInfo.getReleaseRisk());
				jo.put("ReleaseVersion", urInfo.getReleaseVersion());
				jo.put("ReleaseFinishedTime", urInfo.getReleaseFinishedTime());
				jsona.put(jo);
			}
			//获取数量
			JSONObject jsCount = new JSONObject();
			jsCount.put("Amount", list.size());
			jsona.put(jsCount);
			ServletActionContext.getResponse().setHeader("content-type", "application/json");
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			ServletActionContext.getResponse().getWriter().write(jsona.toString());
			
		} catch (Exception e) {
			ServletActionContext.getRequest().setAttribute("errorMsg", e.toString());
		}
	}
	
	public void exportUrgentReleaseInfo() {
		String roleuser = ServletActionContext.getRequest().getParameter("roleuser");
		String startTime = ServletActionContext.getRequest().getParameter("startTime");
		String endTime = ServletActionContext.getRequest().getParameter("endTime");
		String groupName = ServletActionContext.getRequest().getParameter("groupName");
		String productName = ServletActionContext.getRequest().getParameter("productName");
		String releaseType = ServletActionContext.getRequest().getParameter("releaseType");
		String releaseVersion = ServletActionContext.getRequest().getParameter("releaseVersion");
		
		Integer groupId = PP_GroupDAO.getIdByGroup(groupName);
		Integer productId = ProductDAO.getIdByProduct(productName);
		
		UrgentReleaseInfo info = new UrgentReleaseInfo();
		info.setStartTime(startTime);
		info.setEndTime(endTime);
		info.setGroupId(groupId);
		info.setProductId(productId);
		info.setReleaseType(releaseType);
		info.setReleaseVersion(releaseVersion);
		
		UrgentReleaseInfoDAO urgentReleaseInfoDAO = new UrgentReleaseInfoDAO();
		List<UrgentReleaseInfo> urgentReleaseInfos = urgentReleaseInfoDAO.getUrgentReleaseInfo(info);
		
		try {
			int index,row;
			WritableSheet sheet = null;
			WritableWorkbook book = null;
			String pathName = "D:\\Users\\"+roleuser + "\\Downloads\\紧急发布"+System.currentTimeMillis()+".xls";
			File destFile= new File(pathName);
			book = Workbook.createWorkbook(destFile);
			sheet = book.createSheet("UrgentReleaseInfo", 0);
			sheet.setColumnView(0, 10);
			sheet.setColumnView(1, 20);
			sheet.setColumnView(2, 20);
			sheet.setColumnView(3, 20);
			sheet.setColumnView(4, 15);
			sheet.setColumnView(5, 20);
			sheet.setColumnView(6, 20);
			sheet.setColumnView(7, 40);
			sheet.setColumnView(8, 40);
			sheet.setColumnView(9, 10);
			sheet.setColumnView(10, 20);
			sheet.setColumnView(11, 15);
			
			index = 0;
			sheet.addCell(new Label(index++,0,"DB序号"));
			sheet.addCell(new Label(index++,0,"发布产品"));
			sheet.addCell(new Label(index++,0,"APPID"));
			sheet.addCell(new Label(index++,0,"发布类型"));
			sheet.addCell(new Label(index++,0,"申请人"));
			sheet.addCell(new Label(index++,0,"申请时间"));
			sheet.addCell(new Label(index++,0,"开发负责人"));
			sheet.addCell(new Label(index++,0,"测试负责人"));
			sheet.addCell(new Label(index++,0,"紧急发布原因"));
			sheet.addCell(new Label(index++,0,"发布风险"));
			sheet.addCell(new Label(index++,0,"发布版本"));
			sheet.addCell(new Label(index++,0,"发布完成时间"));
			
			row = 1;
			
			for (UrgentReleaseInfo listInfo : urgentReleaseInfos) {
				if(listInfo == null) continue;
				index = 0;
				sheet.addCell(new Number(index++,row,listInfo.getId()));
				sheet.addCell(new Label(index++,row,listInfo.getProductName()));
				sheet.addCell(new Label(index++,row,listInfo.getAppid()));
				sheet.addCell(new Label(index++,row,listInfo.getReleaseType()));
				sheet.addCell(new Label(index++,row,listInfo.getApplicantName()));
				sheet.addCell(new Label(index++,row,listInfo.getAppliedTime()));
				sheet.addCell(new Label(index++,row,listInfo.getDeveloper()));
				sheet.addCell(new Label(index++,row,listInfo.getTester()));
				sheet.addCell(new Label(index++,row,listInfo.getUrgentReleaseReason()));
				sheet.addCell(new Label(index++,row,listInfo.getReleaseRisk()));
				sheet.addCell(new Label(index++,row,listInfo.getReleaseVersion()));
				sheet.addCell(new Label(index++,row,listInfo.getReleaseFinishedTime()));
				row++;
			}
			book.write();
			if(book!=null) book.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

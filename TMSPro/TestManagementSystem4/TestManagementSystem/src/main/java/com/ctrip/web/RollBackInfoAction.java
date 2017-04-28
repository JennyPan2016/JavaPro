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
import com.ctrip.DAO.RollBackInfoDAO;
import com.ctrip.Model.RollBackInfo;

public class RollBackInfoAction {

	/*
	 * 新增发布回退信息
	 */
	public void addRollBackInfo(){
		
		String department=ServletActionContext.getRequest().getParameter("department");//暂时只有基础业务
		String center=ServletActionContext.getRequest().getParameter("center");
		String groupName=ServletActionContext.getRequest().getParameter("groupName");
		String productName=ServletActionContext.getRequest().getParameter("productName");
		String roleuser=ServletActionContext.getRequest().getParameter("roleuser");
		String rollbackType=ServletActionContext.getRequest().getParameter("rollbackType");//堡垒终止、Rolling终止、回滚
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
		String createUser=roleuser;
		String updateUser=roleuser;

		JSONArray jsona = new JSONArray();
		JSONObject jo = new JSONObject();
		String result="";//0 Success,1 Fail,2 no access
		Boolean role=false;
		role=AuthorizationDAO.Authorization(department,center,groupName,roleuser);//判断权限
		if(role){
		
			RollBackInfoDAO rollBackInfoDao=new RollBackInfoDAO();
			
			Integer departmentId=1;//暂时只有基础业务
			Integer centerId=CenterDAO.getIdByCenter(center);
			Integer groupId=PP_GroupDAO.getIdByGroup(groupName,center,department);
			Integer productId=ProductDAO.getIdByProduct(productName);
			Integer developerId=PP_UserDAO.getIdByuserAlias(developer);
			Integer testerId=PP_UserDAO.getIdByuserAlias(tester);
			Integer backCategoryId=rollBackInfoDao.getIdByBackCategory(backCategory);
			Integer backGroupId=rollBackInfoDao.getIdByBackGroup(backGroup);
			Integer createUserId=PP_UserDAO.getIdByuserAlias(createUser);
			Integer updateUserId=PP_UserDAO.getIdByuserAlias(updateUser);
			
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

	/*
	 * 更新发布回退信息
	 */
	public void updateRollBackInfo(){
		String backInfoId=ServletActionContext.getRequest().getParameter("Id");
		String department=ServletActionContext.getRequest().getParameter("department");//暂时只有基础业务
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
		String updateUser=roleuser;
		
		JSONArray jsona = new JSONArray();
		JSONObject jo = new JSONObject();
		String result="";//0 Success,1 Fail,2 no access
		Boolean role=false;
		role=AuthorizationDAO.Authorization(department,center,groupName,roleuser);//判断权限
		if(role){
			RollBackInfoDAO rollBackInfoDAO=new RollBackInfoDAO();
			
			Integer departmentId=1;//暂时只有基础业务
			Integer centerId=CenterDAO.getIdByCenter(center);
			Integer groupId=PP_GroupDAO.getIdByGroup(groupName,center,department);
			Integer productId=ProductDAO.getIdByProduct(productName);
			Integer developerId=PP_UserDAO.getIdByuserAlias(developer);
			Integer testerId=PP_UserDAO.getIdByuserAlias(tester);
			Integer backCategoryId=rollBackInfoDAO.getIdByBackCategory(backCategory);
			Integer backGroupId=rollBackInfoDAO.getIdByBackGroup(backGroup);
			Integer updateUserId=PP_UserDAO.getIdByuserAlias(updateUser);
			
			RollBackInfo rollBackInfo=new RollBackInfo();
			rollBackInfo.setDepartmentId(departmentId);
			rollBackInfo.setCenterId(centerId);
			rollBackInfo.setGroupId(groupId);
			rollBackInfo.setProductId(productId);
			rollBackInfo.setDeveloperId(developerId);
			rollBackInfo.setTesterId(testerId);
			rollBackInfo.setBackCategoryId(backCategoryId);
			rollBackInfo.setBackGroupId(backGroupId);
			rollBackInfo.setUpdateUserId(updateUserId);
			rollBackInfo.setRollbackType(rollbackType);
			rollBackInfo.setRopid(ropid);
			rollBackInfo.setReleaseVersion(releaseVersion);
			rollBackInfo.setStartTime(startTime);
			rollBackInfo.setEndTime(endTime);
			rollBackInfo.setRollbackReason(rollbackReason);
			rollBackInfo.setDescription(description);
			rollBackInfo.setId(Integer.valueOf(backInfoId));
			
			result = rollBackInfoDAO.updateRollBackInfo(rollBackInfo);
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
			jo.put("message", "Sorry! 您没有权限更新!");
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
	
	/*
	 * 查询发布回退信息
	 */
	public void getRollBackInfos(){
		/*debug
		String groupName="登录注册";
		String productName="登录注册";
		String beginDate = "2017-04-10";
		String endDate = "2017-04-20";
		*/
		String department=ServletActionContext.getRequest().getParameter("department");
		String centerName=ServletActionContext.getRequest().getParameter("centerName");
		String groupName=ServletActionContext.getRequest().getParameter("groupName");
		String productName=ServletActionContext.getRequest().getParameter("productName");
		String beginDate =  ServletActionContext.getRequest().getParameter("beginDate");
		String endDate =  ServletActionContext.getRequest().getParameter("endDate");
		Integer groupId=PP_GroupDAO.getIdByGroup(groupName,centerName,department);
		Integer productId=ProductDAO.getIdByProduct(productName);
		
		RollBackInfo backInfo=new RollBackInfo();
		backInfo.setGroupId(groupId);
		backInfo.setProductId(productId);
		backInfo.setBeginDate(beginDate);
		backInfo.setEndDate(endDate);
		
		RollBackInfoDAO backInfoDAO=new RollBackInfoDAO();
		try{
			List<RollBackInfo> list = backInfoDAO.getRollBackInfos(backInfo);
			JSONArray jsona = new JSONArray();
			for(RollBackInfo rbinfo:list){
				JSONObject jO = new JSONObject();
				jO.put("id",rbinfo.getId());
				jO.put("RollbackType", rbinfo.getRollbackType());
				jO.put("ropid", rbinfo.getRopid());
				jO.put("ReleaseVersion", rbinfo.getReleaseVersion());
				jO.put("department", department);
				jO.put("centerName", centerName);
				jO.put("GroupName", rbinfo.getGroupName());
				jO.put("ProductName", rbinfo.getProductName());
				jO.put("StartTime", rbinfo.getStartTime());
				jO.put("EndTime", rbinfo.getEndTime());
				jO.put("RollbackReason", rbinfo.getRollbackReason());
				jO.put("Developer", (new RollBackInfoDAO()).getUserAliasById(rbinfo.getDeveloperId()));
				jO.put("Tester", (new RollBackInfoDAO()).getUserAliasById(rbinfo.getTesterId()));
				jO.put("RollbackCategory", rbinfo.getBackCategory());
				jO.put("RollbackGroup", rbinfo.getBackCategory());
				jO.put("Description", rbinfo.getDescription());
				jO.put("CreateUser", (new RollBackInfoDAO()).getUserAliasById(rbinfo.getCreateUserId()));
				jO.put("UpdateUser", (new RollBackInfoDAO()).getUserAliasById(rbinfo.getUpdateUserId()));	
				jsona.put(jO);
			}
			//获取数量
			JSONObject jsCount=new JSONObject();
			jsCount.put("total", list.size());
			jsona.put(jsCount);
			ServletActionContext.getResponse().setHeader("content-type", "application/json");
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			ServletActionContext.getResponse().getWriter().write(jsona.toString());
		}catch(Exception e){
			ServletActionContext.getRequest().setAttribute("errorMsg", e.toString());
		}
		
	}
	
	/*
	 * 级联查询回退原因分类
	 */
	public void getRollbackCategory(){
		RollBackInfoDAO backInfoDAO=new RollBackInfoDAO();
		try{
			List<RollBackInfo> listBackCategory = backInfoDAO.getRollbackCategory();
			JSONArray jsona=new JSONArray();
			for(RollBackInfo rbinfo:listBackCategory){
				JSONObject jO = new JSONObject();
				jO.put("id", rbinfo.getBackCategoryId());
				jO.put("RollbackCategory", rbinfo.getBackCategory());
				jsona.put(jO);
			}
			ServletActionContext.getResponse().setHeader("content-type", "application/json");
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			ServletActionContext.getResponse().getWriter().write(jsona.toString());
		}catch(Exception e){
			ServletActionContext.getRequest().setAttribute("errorMsg", e.toString());
		}
	}

	/*
	 * 级联根据回退原因分类id获取回退原因分组
	 */
	public void getRollbackGroupByBackCategory(){
		String backCategoryId=ServletActionContext.getRequest().getParameter("backCategoryId");
		
		RollBackInfoDAO rollBackInfoDAO=new RollBackInfoDAO();
		RollBackInfo backInfo=new RollBackInfo();
		backInfo.setBackCategoryId(Integer.valueOf(backCategoryId));
		try{
			List<RollBackInfo> listBackGroup=rollBackInfoDAO.getRollbackGroupByBackCategory(backInfo);
			JSONArray jsona= new JSONArray();
			for(RollBackInfo rbinfo:listBackGroup){
				JSONObject jO =new JSONObject();
				jO.put("id", rbinfo.getBackGroupId());
				jO.put("RollbackGroup", rbinfo.getBackGroup());
				jsona.put(jO);
			}
			ServletActionContext.getResponse().setHeader("content-type", "application/json");
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			ServletActionContext.getResponse().getWriter().write(jsona.toString());	
		}catch(Exception e){
			ServletActionContext.getRequest().setAttribute("errorMsg", e.toString());
		}	
	}
	
	/*
	 * 导出
	 */
	public void rollBackInfosToExcel(){
		String department=ServletActionContext.getRequest().getParameter("department");
		String centerName=ServletActionContext.getRequest().getParameter("centerName");
		String roleuser=ServletActionContext.getRequest().getParameter("roleuser");
		String groupName=ServletActionContext.getRequest().getParameter("groupName");
		String productName=ServletActionContext.getRequest().getParameter("productName");
		String beginDate =  ServletActionContext.getRequest().getParameter("beginDate");
		String endDate =  ServletActionContext.getRequest().getParameter("endDate");
		/*
		String roleuser="fenggao";
		String groupName="登录注册";
		String productName="登录注册";
		String beginDate = "2017-04-10";
		String endDate = "2017-04-20";*/
		Integer groupId=PP_GroupDAO.getIdByGroup(groupName,centerName,department);
		Integer productId=ProductDAO.getIdByProduct(productName);
		
		RollBackInfo backInfo=new RollBackInfo();
		backInfo.setGroupId(groupId);
		backInfo.setProductId(productId);
		backInfo.setBeginDate(beginDate);
		backInfo.setEndDate(endDate);
		
		RollBackInfoDAO backInfoDAO=new RollBackInfoDAO();
		List<RollBackInfo> backInfoList = backInfoDAO.getRollBackInfos(backInfo);
		
		try {
		int index,row;  
        WritableSheet sheet=null;  
        WritableWorkbook book=null;  
        String pathName= "D:\\Users\\"+roleuser+"\\Downloads\\"+System.currentTimeMillis()+".xls";
	    File destFile=new File(pathName);
        book = Workbook.createWorkbook(destFile);  
        sheet = book.createSheet("RollbackInfo", 0);  
        sheet.setColumnView(0, 10);  
        sheet.setColumnView(1, 10);  
        sheet.setColumnView(2, 15);  
        sheet.setColumnView(3, 40);
        sheet.setColumnView(4, 15);  
        sheet.setColumnView(5, 15);  
        sheet.setColumnView(6, 15);  
        sheet.setColumnView(7, 15);  
        sheet.setColumnView(8, 40);  
        sheet.setColumnView(9, 15);  
        sheet.setColumnView(10, 15);  
        sheet.setColumnView(11, 20);  
        sheet.setColumnView(12, 20); 
        
        //字段变量名  
        index=0;  
        sheet.addCell(new Label(index++,0,"DB序号"));  
        sheet.addCell(new Label(index++,0,"回退类型"));  
        sheet.addCell(new Label(index++,0,"rop版本"));  
        sheet.addCell(new Label(index++,0,"发布名称")); 
        sheet.addCell(new Label(index++,0,"产线"));
        sheet.addCell(new Label(index++,0,"产品"));
        sheet.addCell(new Label(index++,0,"开始执行时间"));
        sheet.addCell(new Label(index++,0,"执行结束时间"));  
        sheet.addCell(new Label(index++,0,"回退/终止的原因描述"));  
        sheet.addCell(new Label(index++,0,"开发人员"));  
        sheet.addCell(new Label(index++,0,"测试人员")); 
        sheet.addCell(new Label(index++,0,"回退/终止的原因分类"));
        sheet.addCell(new Label(index++,0,"回退/终止的原因分组"));
        row=1;  
        for(RollBackInfo list:backInfoList){  
            if(list==null) continue;  
            index=0;  
            sheet.addCell(new Number(index++,row,list.getId()));  
            sheet.addCell(new Label(index++,row,list.getRollbackType()));  
            sheet.addCell(new Label(index++,row,list.getRopid()));  
            sheet.addCell(new Label(index++,row,list.getReleaseVersion()));
            sheet.addCell(new Label(index++,row,list.getGroupName()));
            sheet.addCell(new Label(index++,row,list.getProductName()));
            sheet.addCell(new Label(index++,row,list.getStartTime()));  
            sheet.addCell(new Label(index++,row,list.getEndTime()));  
            sheet.addCell(new Label(index++,row,list.getRollbackReason()));
            sheet.addCell(new Label(index++,row,(new RollBackInfoDAO()).getUserAliasById(Integer.valueOf(list.getDeveloperId()))));
            sheet.addCell(new Label(index++,row,(new RollBackInfoDAO()).getUserAliasById(Integer.valueOf(list.getTesterId()))));
            sheet.addCell(new Label(index++,row,list.getBackCategory()));
            sheet.addCell(new Label(index++,row,list.getBackGroup()));
            row++;  
        }  
        book.write();  
        if(book!=null) book.close();
        }catch(Exception e){
        	e.printStackTrace();
        }
	}
}

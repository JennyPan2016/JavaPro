package com.ctrip.web;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;

import com.ctrip.DAO.TestDataDAO;
import com.ctrip.Model.DateByWeek;
import com.ctrip.Model.TestData;

public class TestDataAction {

	/*
	 * 获取测试数据汇总
	 * 时间较长一次性load出分组和个人的测试数据汇总
	 */
	public void getGroupTestDataByGroup(){
		String groupId=ServletActionContext.getRequest().getParameter("groupId");
		String beginDate =  ServletActionContext.getRequest().getParameter("beginDate");
		String endDate =  ServletActionContext.getRequest().getParameter("endDate");
		
		TestDataDAO testDataDAO=new TestDataDAO();
		String testUsers=testDataDAO.getTestUsersByGroupId(Integer.valueOf(groupId));
		String groupName=testDataDAO.getGroupNameByGroupId(Integer.valueOf(groupId));
		String groupLeader=testDataDAO.getGroupLeaderByGroupId(Integer.valueOf(groupId));
		int testUserNum =testDataDAO.getTestUserNumByGroupId(Integer.valueOf(groupId));
				
		TestData testData=new TestData();
		testData.setTestUsers(testUsers);
		testData.setBeginDate(beginDate);
		testData.setEndDate(endDate);
		
		try{
			JSONArray jsona = new JSONArray();
			JSONObject jObject = new JSONObject();
			jObject.put("GroupName", groupName);
			jObject.put("GroupLeader", groupLeader);
			jObject.put("testUserNum", testUserNum);
			jsona.put(jObject);
			List<TestData> bugInfoList=testDataDAO.getBugInfoByTestUsers(testData);
			for(TestData td:bugInfoList){
				JSONObject jO = new JSONObject();
				jO.put("GroupTestBugScore", td.getTestBugScore());
				jO.put("GroupTestBugNum", td.getTestBugNum());
				jO.put("GroupAvailBugNum", td.getAvailBugNum());
				jO.put("GroupCloAndResBugNum", td.getCloAndResBugNum());
				jO.put("GroupLostPercent", td.getLostPercent());
				jO.put("GroupProBugNum", td.getProBugNum());
				jO.put("GroupProBugScore", td.getProBugScore());
				jsona.put(jO);
			}
			List<TestData> backInfoList=testDataDAO.getBackInfoByTestUsers(testData);
			for(TestData tData:backInfoList){
				JSONObject jO=new JSONObject();
				jO.put("GroupBaoleiBackNum",tData.getBaoleiBackNum());
				jO.put("GroupProBackNum", tData.getProBackNum());
				jsona.put(jO);
			}
			String[] testUserArray=testData.getTestUsers().split(",");
			for(int i=0;i<testUserArray.length;i++){
				TestData tD=new TestData();
				tD.setTestUser(testUserArray[i]);
				tD.setBeginDate(beginDate);
				tD.setEndDate(endDate);
				List<TestData> userBugInfoList=testDataDAO.getBugInfoByTestUsers(tD);
				JSONArray userJsona=new JSONArray();
				for(TestData tdData:userBugInfoList){
					JSONObject jo=new JSONObject();
					jo.put("TestUser", tdData.getTestUser());
					jo.put("TestBugNum", tdData.getTestBugNum());
					jo.put("TestBugScore", tdData.getTestBugScore());
					jo.put("AvailBugNum", tdData.getAvailBugNum());
					jo.put("CloAndResBugNum", tdData.getCloAndResBugNum());
					jo.put("ProBugNum", tdData.getProBugNum());
					jo.put("ProBugScore", tdData.getProBugScore());
					jo.put("prdAndDevNum", tdData.getPrdAndDevNum());
					userJsona.put(jo);
				}
				List<TestData> userBackInfoList=testDataDAO.getBackInfoByTestUsers(tD);
				for(TestData tData:userBackInfoList){
					JSONObject jo=new JSONObject();
					jo.put("BaoleiBackNum", tData.getBaoleiBackNum());
					jo.put("ProBackNum", tData.getProBackNum());
					userJsona.put(jo);
				}
				int comTestOwnerNum=testDataDAO.getComTestOwnerNum(tD.getTestUser(),tD.getBeginDate(),tD.getEndDate());
				JSONObject jo=new JSONObject();
				jo.put("comTestOwnerNum", comTestOwnerNum);
				userJsona.put(jo);
				jsona.put(userJsona);
			}
			ServletActionContext.getResponse().setHeader("content-type", "application/json");
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			ServletActionContext.getResponse().getWriter().write(jsona.toString());
		}catch(Exception e){
			ServletActionContext.getRequest().setAttribute("errorMsg", e.toString());
		}
	}
    
	/*
	 * 显示组故障率趋势
	 */
	public void viewGroupLostPercent(){
		String groupId=ServletActionContext.getRequest().getParameter("groupId");
		String currentDate =  ServletActionContext.getRequest().getParameter("currentDate");
		
		try{
			TestDataDAO testDataDAO=new TestDataDAO();
			DateByWeek dateByWeeks=testDataDAO.getWeeksByCurrentDate(currentDate);
			String testUsers=testDataDAO.getTestUsersByGroupId(Integer.valueOf(groupId));
			String groupName=testDataDAO.getGroupNameByGroupId(Integer.valueOf(groupId));
			
			TestData tData=new TestData();
			tData.setTestUsers(testUsers);
			tData.setBeginDate(dateByWeeks.getBeginDate1());
			tData.setEndDate(dateByWeeks.getEndDate1());
			List<TestData> testData1=testDataDAO.getLostPercentByTestUsers(tData);
			tData.setBeginDate(dateByWeeks.getBeginDate2());
			tData.setEndDate(dateByWeeks.getEndDate2());
			List<TestData> testData2=testDataDAO.getLostPercentByTestUsers(tData);
			tData.setBeginDate(dateByWeeks.getBeginDate3());
			tData.setEndDate(dateByWeeks.getEndDate3());
			List<TestData> testData3=testDataDAO.getLostPercentByTestUsers(tData);
			tData.setBeginDate(dateByWeeks.getBeginDate4());
			tData.setEndDate(dateByWeeks.getEndDate4());
			List<TestData> testData4=testDataDAO.getLostPercentByTestUsers(tData);
			
			JSONArray jsona=new JSONArray();
			for(TestData td1:testData1){
				JSONObject jO=new JSONObject();
				jO.put("beginDate1", td1.getBeginDate());
				jO.put("endDate1", td1.getEndDate());
				jO.put("lostPercent1", td1.getLostPercent());
				jsona.put(jO);
			}
			for(TestData td2:testData2){
				JSONObject jO=new JSONObject();
				jO.put("beginDate2", td2.getBeginDate());
				jO.put("endDate2", td2.getEndDate());
				jO.put("lostPercent2", td2.getLostPercent());
				jsona.put(jO);
			}
			for(TestData td3:testData3){
				JSONObject jO=new JSONObject();
				jO.put("beginDate3", td3.getBeginDate());
				jO.put("endDate3", td3.getEndDate());
				jO.put("lostPercent3", td3.getLostPercent());
				jsona.put(jO);
			}
			for(TestData td4:testData4){
				JSONObject jO=new JSONObject();
				jO.put("beginDate4", td4.getBeginDate());
				jO.put("endDate4", td4.getEndDate());
				jO.put("lostPercent4", td4.getLostPercent());
				jsona.put(jO);
			}
			JSONObject jo=new JSONObject();
			jo.put("groupName", groupName);
			jsona.put(jo);
			ServletActionContext.getResponse().setHeader("content-type", "application/json");
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			ServletActionContext.getResponse().getWriter().write(jsona.toString());
		}catch(Exception e){
			ServletActionContext.getRequest().setAttribute("errorMsg", e.toString());
		}
	}
}

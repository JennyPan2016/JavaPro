package com.ctrip.DAO;

import java.sql.Connection;
import java.sql.Statement;

import com.ctrip.Model.SmokingReport;
import com.ctrip.Model.SmokingReportContent;
import com.ctrip.Utility.ConnectionDB;

public class SmokingReportDAO {
	/*
	 * author:full
	 */
	public String saveSmokingReport(SmokingReport smokingReport){
		Boolean autoCommit = true;
		Connection conn = (new ConnectionDB()).connectionDB();
		String result = "";
		
		try{
			autoCommit = conn.getAutoCommit();//获得当前状态
			conn.setAutoCommit(false);//关闭自动提交功能
			Statement stat = conn.createStatement();
			
			int createUserID = PP_UserDAO.getIdByUserName(smokingReport.getCreateUser());
			if(createUserID!=0){
				smokingReport.setCreateUserID(createUserID);
			}
			
			String insertReport = "insert into SmokingReport (ProjectID,title,Tester,DeveloperManager,ProjectDeliverTime,"
					+ "DeliverToTestInTime,ScheDeliverToTestTime,RealDeliverToTestTime,TestEnv,TestRound,SmokingResult,ExistRisk,"
					+ "CreateUserID,CreateTime) values ('" + smokingReport.getProjectID() + "','" + smokingReport.getTitle() + "','" + smokingReport.getTester()
					+ "','" + smokingReport.getDeveloperManager() + "','" + smokingReport.getProjectDeliverTime() + "','" 
					+ smokingReport.getDeliverToTestInTime() + "','" + smokingReport.getScheDeliverToTestTime() + "','" + smokingReport.getRealDeliverToTestTime()
					+ "','" + smokingReport.getTestEnv() + "','" + smokingReport.getTestRound() + "','" + smokingReport.getSmokingResult()
					+ "','" + smokingReport.getExistRisk() + "','" + smokingReport.getCreateUserID() + "',getDate())";
			
			stat.executeUpdate(insertReport);
			conn.commit();

			conn.setAutoCommit(autoCommit);//恢复场景
			System.out.println("保存成功");
			result = "Success";
			
		}catch(Exception e){
			System.out.println(e);
			result = e.toString();
			try{
				conn.rollback();
			}catch(Exception ro){
				ro.printStackTrace();
			}
		}
		finally{
			try{
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public String saveSmokingReportContent(SmokingReportContent smokingReportContent){
		Boolean autoCommit = true;
		Connection conn = (new ConnectionDB()).connectionDB();
		String result = "";
		
		try{
			autoCommit = conn.getAutoCommit();//获得当前状态
			conn.setAutoCommit(false);//关闭自动提交功能
			Statement stat = conn.createStatement();
			
			String insertReportContent = "insert into SmokingReportContent (SmokingReportID, Testpoint, TestResult, Remarks, CreateTime)"
					+ " values ('" + smokingReportContent.getSmokingReportID() + "','" + smokingReportContent.getTestpoint() 
					+ "','" + smokingReportContent.getTestResult() + "','" + smokingReportContent.getRemarks() + "',getDate())";
			
			stat.executeUpdate(insertReportContent);
			conn.commit();

			conn.setAutoCommit(autoCommit);//恢复场景
			System.out.println("保存成功");
			result = "Success";
			
		}catch(Exception e){
			System.out.println(e);
			result = e.toString();
			try{
				conn.rollback();
			}catch(Exception ro){
				ro.printStackTrace();
			}
		}
		finally{
			try{
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}

}

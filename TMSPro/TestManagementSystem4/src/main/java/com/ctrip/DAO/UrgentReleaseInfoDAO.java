package com.ctrip.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ctrip.Model.UrgentReleaseInfo;
import com.ctrip.Utility.ConnectionDB;

public class UrgentReleaseInfoDAO {
	
	public String addUrgentReleaseInfo(UrgentReleaseInfo releaseInfo){
		Boolean autoCommit = true;
		Connection conn=(new ConnectionDB()).connectionDB();
		String result = "";
		try
		{
			autoCommit=conn.getAutoCommit();
			conn.setAutoCommit(false);
			Statement state=conn.createStatement();
			
			String addSql="insert into ProcessPlatform..UrgentReleaseInfo(AppID,ReleaseType,Applicant,AppliedTime,"
					+ "Reason,DeveloperID,TesterID,ReleaseRisk,ReleaseVersion,status,Description,"
					+ "CreateUserID,UpdateUserID,CreateTime,UpdateTime,productId,departmentId,centerId,ReleaseFinishedTime) VALUES "
					+ "('"+releaseInfo.getAppid()+"','"+releaseInfo.getReleaseType()+"','"+releaseInfo.getApplicant()+"',"
					+ ""+releaseInfo.getAppliedTime()+",'"+releaseInfo.getUrgentReleaseReason()+"',"+releaseInfo.getDeveloperId()+","
					+releaseInfo.getTesterId()+"," + ""+releaseInfo.getReleaseRisk()+","+releaseInfo.getReleaseVersion()+", 'T', '"
					+releaseInfo.getDescription()+"'," + ""+releaseInfo.getCreateUserId()+","+releaseInfo.getUpdateUserId() + ",getDate(),getDate()," 
					+ ""+releaseInfo.getProductId()+","+releaseInfo.getDepartmentId()+","+releaseInfo.getCenterId()+releaseInfo.getReleaseFinishedTime()+");";
			
			state.executeUpdate(addSql);
			conn.commit();
			
			conn.setAutoCommit(autoCommit);
			result="Success";
			
		}catch(Exception e){
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
	
	public String deleteInfoById(UrgentReleaseInfo releaseInfo) {
		Boolean autoCommit = true;
		Connection conn=(new ConnectionDB()).connectionDB();
		String result = "";
		try {
			autoCommit = conn.getAutoCommit();
			conn.setAutoCommit(false);
			Statement state=conn.createStatement();
			
			String deleteSql = "UPDATE ProcessPlatform..UrgentReleaseInfo SET status = 'F', updateUserID = "
					+ releaseInfo.getUpdateUserId() + ", updatetime = getDate() "
					+ "WHERE id = " + releaseInfo.getId() +";";
			
			state.execute(deleteSql);
			conn.commit();
			
			conn.setAutoCommit(autoCommit);
			result = "Success";
			
		} catch (Exception e) {
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
	
	public List<UrgentReleaseInfo> getUrgentReleaseInfo(UrgentReleaseInfo info) {
		Connection conn = (new ConnectionDB()).connectionDB();
		List<UrgentReleaseInfo> list = new ArrayList<UrgentReleaseInfo>();
		
		try {
			Statement state = conn.createStatement();
			String querySql = "SELECT u.id, p.ProductName, u.appid, u.ReleaseType, "
					+ "pu3.username as ApplicantName, u.AppliedTime, pu1.username as developer, "
					+ "pu2.username as Tester, u.Reason, u.ReleaseRisk, u.ReleaseVersion, u.ReleaseFinishedTime "
					+ "FROM ProcessPlatform..UrgentReleaseInfo u "
					+ "JOIN ProcessPlatform..Product p ON u.ProductId = p.id "
					+ "JOIN ProcessPlatform..PP_User pu1 ON pu1.id = u.DeveloperID "
					+ "JOIN ProcessPlatform..PP_User pu2 ON pu2.id = u.TesterID "
					+ "JOIN ProcessPlatform..PP_User pu3 ON pu3.id = u.Applicant "
					+ "WHERE u.status = 'T' and u.startTime >= " + info.getStartTime()
					+ " and u.endTime <= " + info.getEndTime();
			if(info.getGroupId() != null && info.getGroupId() > 0) {
				querySql += " and u.groupid = " + info.getGroupId();
			}
			if(info.getProductId() != null && info.getGroupId() >0) {
				querySql += " and u.productid = " + info.getProductId();
			}
			if(info.getReleaseType() != null) {
				querySql += " and u.releasetype = " + info.getReleaseType();
			}
			if(info.getReleaseVersion() != null) {
				querySql += " and u.releaseversion = " + info.getReleaseVersion();
			}
			querySql += ";";
			
			ResultSet resultSet = state.executeQuery(querySql);
			while(resultSet.next()) {
				UrgentReleaseInfo urgentReleaseInfo = new UrgentReleaseInfo();
				urgentReleaseInfo.setId(Integer.valueOf(resultSet.getString("id")));
				urgentReleaseInfo.setProductName(resultSet.getString("ProductName"));
				urgentReleaseInfo.setAppid(resultSet.getString("appid"));
				urgentReleaseInfo.setReleaseType(resultSet.getString("ReleaseType"));
				urgentReleaseInfo.setApplicantName(resultSet.getString("ApplicantName"));
				urgentReleaseInfo.setAppliedTime(resultSet.getString("AppliedTime"));
				urgentReleaseInfo.setDeveloper(resultSet.getString("developer"));
				urgentReleaseInfo.setTester(resultSet.getString("Tester"));
				urgentReleaseInfo.setUrgentReleaseReason(resultSet.getString("Reason"));
				urgentReleaseInfo.setReleaseRisk(resultSet.getString("ReleaseRisk"));
				urgentReleaseInfo.setReleaseVersion(resultSet.getString("ReleaseVersion"));
				urgentReleaseInfo.setReleaseFinishedTime(resultSet.getString("ReleaseFinishedTime"));
				list.add(urgentReleaseInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}

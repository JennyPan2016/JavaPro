package com.ctrip.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.ctrip.Model.RollBackInfo;
import com.ctrip.Utility.ConnectionDB;

public class RollBackInfoDAO {
	
	public String addRollBackInfo(RollBackInfo backInfo){
		Boolean autoCommit = true;
		Connection conn=(new ConnectionDB()).connectionDB();
		String result = "";
		try
		{
			autoCommit=conn.getAutoCommit();
			conn.setAutoCommit(false);
			Statement state=conn.createStatement();
			
			String addSql="insert into ProcessPlatform..RollbackInfo(RollbackType,ropid,ReleaseVersion,Group,"
					+ "StartTime,EndTime,RollbackReason,Developer,Tester,RollbackCategory,RollbackGroup,Description,"
					+ "CreateUserID,UpdateUserID,CreateTime,UpdateTime,productId,departmentId,centerId) VALUES "
					+ "('"+backInfo.getRollbackType()+"','"+backInfo.getRopid()+"','"+backInfo.getReleaseVersion()+"',"
					+ ""+backInfo.getGroupId()+",'"+backInfo.getStartTime()+"','"+backInfo.getEndTime()+"',"
				    + "'"+backInfo.getRollbackReason()+"',"+backInfo.getDeveloperId()+","+backInfo.getTesterId()+","
				    + ""+backInfo.getBackCategoryId()+","+backInfo.getBackGroupId()+",'"+backInfo.getDescription()+"',"
				    + ""+backInfo.getCreateUserId()+","+backInfo.getUpdateUserId()+",getDate(),getDate(),"
				    + ""+backInfo.getProductId()+","+backInfo.getDepartmentId()+","+backInfo.getCenterId()+");";
			
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
	
	public int getIdByBackCategory(String backCategory){
		int backCategoryId = 0;
		Connection conn = (new ConnectionDB()).connectionDB();
		try{
			Statement stat = conn.createStatement();
			String sql = "select id from ProcessPlatform..RollbackCategory where RollbackCategory = '" + backCategory + "'";
			
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()){
				backCategoryId = rs.getInt("id");
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return backCategoryId;
	}
	
	public int getIdByBackGroup(String backGroup){
		int backGroupId = 0;
		Connection conn = (new ConnectionDB()).connectionDB();
		try{
			Statement stat = conn.createStatement();
			String sql = "select id from ProcessPlatform..RollbackGroup where RollbackGroup = '" + backGroup + "'";
			
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()){
				backGroupId = rs.getInt("id");
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return backGroupId;
	}

}

package com.ctrip.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.ctrip.Utility.ConnectionDB;

public class PP_GroupDAO {
	/*
	 * author:full
	 */
	public int getIdByGroup(String group){
		int groupId = 0;
		Connection conn = (new ConnectionDB()).connectionDB();
		try{
			Statement stat = conn.createStatement();
			String sql = "select id from ProcessPlatform..PP_Group where groupName = '" + group + "'";
			
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()){
				groupId = rs.getInt("id");
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return groupId;
	}
	
	public static int getIdByGroup(String group,String Center,String Department){
		int groupId = 0;
		Connection conn = (new ConnectionDB()).connectionDB();
		try{
			Statement stat = conn.createStatement();
			String sql = "select c.id from ProcessPlatform..Department a,ProcessPlatform..Center b,ProcessPlatform..PP_Group c "
					+ "where a.id=b.DepartmentId and b.id=c.CenterId and a.DepartmentName='"+Department+"' and "
							+ "b.CenterName='"+Center+"' and c.GroupName='"+group+"'";
			
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()){
				groupId = rs.getInt("id");
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return groupId;
	}
}

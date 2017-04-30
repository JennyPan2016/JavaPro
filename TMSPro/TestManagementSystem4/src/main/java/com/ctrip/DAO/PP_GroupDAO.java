package com.ctrip.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.ctrip.Utility.ConnectionDB;

public class PP_GroupDAO {
	
	/*
	 * author:went
	 */
	public static String getleaderbyid(int groupID) {
		String UserAlias = "";
		Connection conn = (new ConnectionDB()).connectionDB();
		try{
			Statement stat = conn.createStatement();
			String sql = "select UserAlias from ProcessPlatform..PP_User where GroupID='"+groupID+"' and UserRole=5 ;";
			
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()){
				UserAlias = rs.getString("UserAlias");
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return UserAlias;
	}
	/*
	 * author:went
	 */
	public static int getcenteridByGroup(int groupID) {
		int CenterId = 0;
		Connection conn = (new ConnectionDB()).connectionDB();
		try{
			Statement stat = conn.createStatement();
			String sql = "select CenterId from ProcessPlatform..PP_Group where id = '" + groupID + "'";
			
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()){
				CenterId = rs.getInt("CenterId");
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return CenterId;
	}
	/*
	 * author:full
	 */
	public static int getIdByGroup(String group){
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
	
	public static void main(String args[]){
	
		System.out.println(getleaderbyid(2));
	}

}

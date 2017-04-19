package com.ctrip.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.ctrip.Utility.ConnectionDB;

public class UserRole {
	/*
	 * author:went
	 */
	public  String getUserRoleByRoleID(int RoleID){
		String  RoleName ="";
		Connection conn = (new ConnectionDB()).connectionDB();
		try{
			Statement stat = conn.createStatement();
			String sql = "select * from ProcessPlatform..UserRole where id="+RoleID+";";
			
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()){
				RoleName = rs.getString("RoleName");
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return RoleName;
	}
	
}

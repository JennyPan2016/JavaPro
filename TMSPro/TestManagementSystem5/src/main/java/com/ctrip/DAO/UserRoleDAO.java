package com.ctrip.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.ctrip.Model.UserRole;
import com.ctrip.Utility.ConnectionDB;

public class UserRoleDAO {

	/*
	 * author:went
	 */
	public static ArrayList<UserRole> getRoleNameList()
	{
		ArrayList<UserRole> al=new ArrayList<UserRole>();
		String  RoleName ="";
		Connection conn = (new ConnectionDB()).connectionDB();
		try{
			Statement stat = conn.createStatement();
			String sql = "select RoleName from ProcessPlatform..UserRole;";
			
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()){
				UserRole role=new UserRole();
				RoleName = rs.getString("RoleName");
				role.setRoleName(RoleName);
				al.add(role);
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return  al;
	}
}

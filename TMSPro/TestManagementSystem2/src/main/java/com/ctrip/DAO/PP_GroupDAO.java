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
}

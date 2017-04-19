package com.ctrip.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.ctrip.Utility.ConnectionDB;

public class CenterDAO {
	/*
	 * author:full
	 */
	public int getIdByCenter(String center){
		int centerId = 0;
		Connection conn = (new ConnectionDB()).connectionDB();
		try{
			Statement stat = conn.createStatement();
			String sql = "select id from ProcessPlatform..Center where centerName = '" + center + "'";
			
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()){
				centerId = rs.getInt("id");
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return centerId;
	}

}

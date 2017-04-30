package com.ctrip.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.ctrip.Utility.ConnectionDB;

public class DepartmentDAO {
	
	/*
	 * 查询id, pan.jing	
	 * */	
	public static int getIdByDeptName(String name){		
		Connection conn = new ConnectionDB().connectionDB();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int departmentId = 0;
		try {
			String sql = "select id from ProcessPlatform..Department where departmentName = ?";				
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);			
			rs = pstmt.executeQuery();
			while (rs.next()){				
				departmentId = rs.getInt("id");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				pstmt.close();
				conn.close();
			}catch(Exception eclose){
				eclose.printStackTrace();
			}
		}
		return departmentId;
	}

}

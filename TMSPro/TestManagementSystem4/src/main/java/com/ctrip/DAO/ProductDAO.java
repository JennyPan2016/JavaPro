package com.ctrip.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.ctrip.Utility.ConnectionDB;

public class ProductDAO {
	/*
	 * author:full
	 */
	public static int getIdByProduct(String product){
		int productId = 0;
		Connection conn = (new ConnectionDB()).connectionDB();
		try{
			Statement stat = conn.createStatement();
			String sql = "select id from ProcessPlatform..Product where productName = '" + product + "'";
			
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()){
				productId = rs.getInt("id");
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return productId;
	}
}

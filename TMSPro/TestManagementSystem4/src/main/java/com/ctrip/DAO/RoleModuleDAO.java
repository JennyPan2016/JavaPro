package com.ctrip.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.ctrip.Utility.ConnectionDB;

public class RoleModuleDAO {
	
	/*
	 * author:went
	 */
	public static ArrayList<Integer> getGroupIDByUserID(int UserID){
		ArrayList<Integer>  al= new ArrayList<Integer>(); 
		int GroupID=0;
		Connection conn = (new ConnectionDB()).connectionDB();
		try{
			Statement stat = conn.createStatement();
			String sql = "select b.GroupID from ProcessPlatform..PP_User a,ProcessPlatform..Module b,"
					+ "ProcessPlatform..RoleModule c where b.id=c.ModuleID and a.UserRole=c.RoleID  and a.id="+UserID+"";
			
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()){
				GroupID = rs.getInt("GroupID");
				al.add(GroupID);
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return al;
	}
	
	 public static void main(String[] args) 
     {
         System.out.println(getGroupIDByUserID(2));
    }

}

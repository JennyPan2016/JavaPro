package com.ctrip.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ctrip.Utility.ConnectionDB;

public class PP_UserDAO {
	/*
	 * author:full
	 */
	public static int getIdByUserName(String user){
		int uid = 0;
		Connection conn = (new ConnectionDB()).connectionDB();
		try{
			Statement stat = conn.createStatement();
			String sql = "select id from ProcessPlatform..PP_User where userName = '" + user + "'";
			
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()){
				uid = rs.getInt("id");
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return uid;
	}
	
	/*
	 * author:full
	 */
	public String getIdListByUser(String userList){
		String uidList = "";
		String userPram = "";
		List<String> idList = new ArrayList<String>();
		
		Connection conn = (new ConnectionDB()).connectionDB();
		if(userList.contains(",")){
			String[] str = userList.split(",");
			for (int i=0;i<str.length;i++){
				userPram = userPram + "'" + str[i] + "',";
			}
			userPram = userPram.substring(0, userPram.length()-1);
		}else{
			userPram = "'" + userList + "'";
		}
		
		try{
			Statement stat = conn.createStatement();
			String sql = "select id from ProcessPlatform..PP_User where userName in (" + userPram + ")";
			
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()){
				idList.add(rs.getString("id"));
			}
			
			if(idList.size()>1){
				for(String id:idList){
					uidList = uidList + "," + id;
				}
				uidList = uidList.substring(1, uidList.length());
			}else{
				uidList = idList.get(0);
			}
			
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return uidList;
	}
	
	/*
	 * author:full
	 */
	public String getUserListUID(String uidList){
		String userList = "";
		List<String> uList = new ArrayList<String>();
		
		Connection conn = (new ConnectionDB()).connectionDB();
		
		try{
			Statement stat = conn.createStatement();
			String sql = "select userName from ProcessPlatform..PP_User where id in (" + uidList + ")";
			
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()){
				uList.add(rs.getString("userName"));
			}
			
			if(uList.size()>1){
				for(String id:uList){
					userList = userList + "," + id;
				}
				userList = userList.substring(1, userList.length());
			}else{
				userList = uList.get(0);
			}
			
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return userList;
	}
	
	/*
	 * author:went
	 */
	public static int getGroupIDByUserID(int UserID){ 
		int GroupID=0;
		Connection conn = (new ConnectionDB()).connectionDB();
		try{
			Statement stat = conn.createStatement();
			String sql = "select GroupID from ProcessPlatform..PP_User  where id="+UserID+"";
			
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()){
				GroupID = rs.getInt("GroupID");
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return GroupID;
	}
	
	public static void main(String args[]){
		String userList = "full,test001";
		PP_UserDAO pp = new PP_UserDAO();
		System.out.println(pp.getIdListByUser(userList));
	}


}

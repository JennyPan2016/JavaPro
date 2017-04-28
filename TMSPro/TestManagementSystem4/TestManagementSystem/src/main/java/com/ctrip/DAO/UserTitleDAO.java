package com.ctrip.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.ctrip.Model.UserTitle;
import com.ctrip.Utility.ConnectionDB;

public class UserTitleDAO {
	
	/*
	 * author:went
	 */
	public static  ArrayList<UserTitle> getUserTitleList(int groupid)
	{
		ArrayList<UserTitle> al=new ArrayList<UserTitle>();
		String  TitleName ="";
		String sql = "";
		Connection conn = (new ConnectionDB()).connectionDB();
		try{
			Statement stat = conn.createStatement();
			if(PP_GroupDAO.getleaderbyid(groupid)==null&&(PP_GroupDAO.getleaderbyid(groupid)).length()<=0)
			{
				sql = "SELECT TitleName FROM [ProcessPlatform].[dbo].[UserTitle]";
			}else{
				sql = "SELECT TitleName FROM [ProcessPlatform].[dbo].[UserTitle] where id!=5";
			}
			
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()){
				UserTitle title=new UserTitle();
				TitleName = rs.getString("TitleName");
				title.setTitleName(TitleName);
				al.add(title);
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return al;
	}
	
}

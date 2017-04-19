package com.ctrip.DAO;

import java.util.ArrayList;

public class AuthorizationDAO {
	
	/*
	 * author:went
	 */
	public static boolean Authorization(String Department,String Center,String PP_Group,String username) 
	{
		int GroupID=PP_GroupDAO.getIdByGroup(PP_Group,Center,Department);
		int UserID=PP_UserDAO.getIdByUserName(username);
		return Authorization(GroupID,UserID);
	}
	
	public static boolean Authorization(int GroupID,int UserID)  
	{
		ArrayList<Integer>  al= new ArrayList<Integer>(); 
		al=RoleModuleDAO.getGroupIDByUserID(UserID);
		al.add(PP_UserDAO.getGroupIDByUserID(UserID));
		return al.contains(GroupID);
	}
	
	 public static void main(String[] args) 
     {
         //System.out.println(Authorization("基础业务研发部","用户中心","我携订单","test001"));
         System.out.println(Authorization(1,1));
     }
}

package com.ctrip.DAO;

public class AuthorizationDAO {
	
	/*
	 * author:went
	 */
	/*
	 * 基于组的权限管理
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
	}*/
	
	/*
	 * 基于center的权限管理*/
	public static boolean Authorization(String Department,String Center,String PP_Group,String username) 
	{
		int GroupID=PP_GroupDAO.getIdByGroup(PP_Group,Center,Department);
		int UserID=PP_UserDAO.getIdByuserAlias(username);
		return Authorization(GroupID,UserID);
	}
	
	public static boolean Authorization(int GroupID,int UserID)  
	{
		boolean flag=false;
		int center_user=PP_UserDAO.getCenterIDByUserID(UserID);
		int center_update=PP_GroupDAO.getcenteridByGroup(GroupID);
		if(center_user==center_update)
		{
			flag=true;
		}
		return flag;
	}
	
	 public static void main(String[] args) 
     {
         System.out.println(Authorization("基础业务研发部","用户中心","登录注册","pj"));
         //System.out.println(Authorization(1,1));
     }
}

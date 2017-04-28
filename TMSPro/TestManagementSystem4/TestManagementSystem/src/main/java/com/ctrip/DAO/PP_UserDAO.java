package com.ctrip.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ctrip.Model.Log;
import com.ctrip.Model.PP_User;
import com.ctrip.Utility.ConnectionDB;

public class PP_UserDAO {
	/*
	 * author:went
	 */
	public static String deleteUser(int userid)
	{
		Boolean autoCommit = true;
		Connection conn = (new ConnectionDB()).connectionDB();
		String result = "";
		try{
			autoCommit = conn.getAutoCommit();//获得当前状态
			conn.setAutoCommit(false);//关闭自动提交功能
			Statement stat = conn.createStatement();
			
			String updateUser = "update ProcessPlatform..PP_User set isHide=1 where id="+userid+"";
			
			stat.executeUpdate(updateUser);
			conn.commit();
			conn.setAutoCommit(autoCommit);//恢复场景
		
			System.out.println("删除成功");
			result = "Success";
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			Log log=new Log();
			log.setUserid(userid);
			log.setOperationType("deleteuser");
			log.setOperationModel("权限管理模块");
			log.setOperationDetail(updateUser);
			log.setRemarks("删除用户信息");
			log.setCreateTime(df.format(new Date()));
			LogDAO.addLog(log);
			
		}catch(Exception e){
			System.out.println(e);
			result = e.toString();
			try{
				conn.rollback();
			}catch(Exception ro){
				ro.printStackTrace();
			}
		}
		finally{
			try{
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}
	/*
	 * author:went
	 */
	public static ArrayList<PP_User> getUserinfo(String DepartmentName,String CenterName,String GroupName,String UserAlias)
	{
		ArrayList<PP_User> al=new ArrayList<PP_User>();
		Connection conn = (new ConnectionDB()).connectionDB();
		try{
			Statement stat = conn.createStatement();
			
			String sql = "select b.DepartmentName,c.CenterName,e.GroupName,a.UserName,a.UserAlias,a.Email,f.RoleName,"
					+ "h.TitleName from ProcessPlatform..PP_User a,ProcessPlatform..Department b ,ProcessPlatform..Center c ,"
					+ "ProcessPlatform..PP_Group e,ProcessPlatform..UserRole f,ProcessPlatform..UserTitle h ,ProcessPlatform..Product g "
					+ "where a.CenterID=c.id and b.id=c.DepartmentId and e.id=a.GroupID and f.id=a.UserRole and h.id=a.UserTile  and a.ProductID=g.id and a.isHide=0";
			
			
			if(DepartmentName!= null && DepartmentName.length()>= 0)
			{
				sql+="and b.DepartmentName='"+DepartmentName+"' ";
			}
			if(CenterName!= null && CenterName.length()>= 0)
			{
				sql+="and c.CenterName='"+CenterName+"' ";
			}
			if(GroupName!= null && GroupName.length()>= 0)
			{
				sql+="and e.GroupName='"+GroupName+"'";
			}
			if(UserAlias!= null && UserAlias.length()>= 0)
			{
				sql+="and a.UserAlias='"+UserAlias+"'";
			}
			
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()){
				PP_User user=new PP_User();
				user.setId(rs.getInt("id"));
				user.setDepartmentName(rs.getString("DepartmentName"));
				user.setCenterName(rs.getString("CenterName"));
				user.setGroupName(rs.getString("GroupName"));
				user.setUserAlias(rs.getString("UserAlias"));
				user.setUserName(rs.getString("UserName"));
				user.setEmail(rs.getString("Email"));
				user.setRoleName(rs.getString("RoleName"));
				user.setTitleName(rs.getString("TitleName"));
				al.add(user);
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return al;
	}
	
	/*
	 * author:went
	 */
	public static String addUser(PP_User user)
	{
		Boolean autoCommit = true;
		Connection conn = (new ConnectionDB()).connectionDB();
		String result = "";
		try{
			autoCommit = conn.getAutoCommit();//获得当前状态
			conn.setAutoCommit(false);//关闭自动提交功能
			Statement stat = conn.createStatement();
			
			if(user.getProductId()!=0 && user.getGroupId()!=0 && user.getCenterId()!=0 && user.getUserRole()!=0&& user.getUserTitle()!=0){
				user.setCenterId(PP_GroupDAO.getcenteridByGroup(user.getGroupId()));	
			}else{
				throw new Exception("addUser: 数据格式异常");
			}
			
			String insertUser = "insert into ProcessPlatform..PP_User(serName,UserAlias,Email,ProductID,"
					+ "GroupID,CenterID,UserRole,UserTile,CreateTime,UpdateTime)values('"+user.getUserName()+"','"+user.getUserAlias()+"','"
					+user.getEmail()+"','1','"+user.getGroupId()+"','"+user.getCenterId()+"','"+user.getUserRole()+"','"+user.getUserTitle()+"',getdate(),getdate());";
			
			stat.executeUpdate(insertUser);
			conn.commit();

			conn.setAutoCommit(autoCommit);//恢复场景
			System.out.println("保存成功");
			result = "Success";
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			Log log=new Log();
			log.setUserid(PP_UserDAO.getIdByuserAlias(user.getUserAlias()));
			log.setOperationType("adduser");
			log.setOperationModel("权限管理模块");
			log.setOperationDetail(insertUser);
			log.setRemarks("增加用户");
			log.setCreateTime(df.format(new Date()));
			LogDAO.addLog(log);
			
		}catch(Exception e){
			System.out.println(e);
			result = e.toString();
			try{
				conn.rollback();
			}catch(Exception ro){
				ro.printStackTrace();
			}
		}
		finally{
			try{
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}
	
	/*
	 * author:went
	 */
	public static String updateUser(PP_User user)
	{
		Boolean autoCommit = true;
		Connection conn = (new ConnectionDB()).connectionDB();
		String result = "";
		try{
			autoCommit = conn.getAutoCommit();//获得当前状态
			conn.setAutoCommit(false);//关闭自动提交功能
			Statement stat = conn.createStatement();
			
			if(user.getProductId()!=0){
				user.setCenterId(PP_GroupDAO.getcenteridByGroup(user.getGroupId()));		
			}else{
				throw new Exception("addUser: 数据格式异常");
			}		
			
			String updateUser = "update ProcessPlatform..PP_User set UserAlias='"+user.getUserAlias()+"',Email='"+user.getEmail()
					+"',ProductID='1',GroupID='"+user.getGroupId()+"',CenterID='"+user.getCenterId()
					+"',UserRole='"+user.getUserRole()+"',UserTile='"+user.getUserTitle()+"',UpdateTime=getdate() where id='"+user.getId()+"'";
			
			stat.executeUpdate(updateUser);
			conn.commit();
			conn.setAutoCommit(autoCommit);//恢复场景
		
			System.out.println("修改成功");
			result = "Success";
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			Log log=new Log();
			log.setUserid(user.getId());
			log.setOperationType("adduser");
			log.setOperationModel("权限管理模块");
			log.setOperationDetail(updateUser);
			log.setRemarks("修改用户信息");
			log.setCreateTime(df.format(new Date()));
			LogDAO.addLog(log);
			
		}catch(Exception e){
			System.out.println(e);
			result = e.toString();
			try{
				conn.rollback();
			}catch(Exception ro){
				ro.printStackTrace();
			}
		}
		finally{
			try{
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}
	
	/*
	 * author:went
	 */
	public static int getIdByuserAlias(String user){
		int uid = 0;
		Connection conn = (new ConnectionDB()).connectionDB();
		try{
			Statement stat = conn.createStatement();
			String sql = "select id from ProcessPlatform..PP_User where userAlias = '" + user + "'";
			
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
	public static int getIdByUserName(String user){
		int uid = 0;
		Connection conn = (new ConnectionDB()).connectionDB();
		try{
			Statement stat = conn.createStatement();
			String sql = "select id from ProcessPlatform..PP_User where userAlias = '" + user + "'";
			
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
	public static int getCenterIDByUserID(int UserID){ 
		int CenterID=0;
		Connection conn = (new ConnectionDB()).connectionDB();
		try{
			Statement stat = conn.createStatement();
			String sql = "select CenterID from ProcessPlatform..PP_User  where id="+UserID+"";
			
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()){
				CenterID = rs.getInt("CenterID");
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return CenterID;
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
	
	/*
	public static void main(String args[]){
		String userList = "full,test001";
		PP_UserDAO pp = new PP_UserDAO();
		System.out.println(addUser("","","",""));
	}*/


}

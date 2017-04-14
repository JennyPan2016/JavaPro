package com.ctrip.DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ctrip.Model.DeliverList;
import com.ctrip.Utility.ConnectionDB;



public class DeliverListDAO {
	
	//新增发布单, pan.jing
	public String insertDeliverList(DeliverList dlist) {
		PreparedStatement pstmt = null;
		Connection conn = new ConnectionDB().connectionDB();
		Boolean autoCommit = true;
		String result = null;
		try {
			autoCommit = conn.getAutoCommit();//获得当前状态
			conn.setAutoCommit(false);  //关闭自动提交功能
			String sql = "insert into ProcessPlatform..DeliverList(projectId,taskId,title,deliverNo,developer,tester,applicationName,content,comments,createUserId,updateUserId,createTime,updateTime)"
					+ " values (?,?,?,?,?,?,?,?,?,?,?,GETDATE(),GETDATE())";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, dlist.getProjectId());  
			pstmt.setInt(2, dlist.getTaskId());
			pstmt.setString(3, dlist.getTitle());
			pstmt.setString(4, dlist.getDeliverNo());
			pstmt.setInt(5, dlist.getDeveloper());
			pstmt.setInt(6, dlist.getTester());
			pstmt.setString(7, dlist.getApplicationName());
			pstmt.setString(8, dlist.getContent());
			pstmt.setString(9, dlist.getComments());
			pstmt.setInt(10, dlist.getCreateUserId());
			pstmt.setInt(11, dlist.getUpdateUserId());	
			
			pstmt.executeUpdate();
			conn.commit(); 
			conn.setAutoCommit(autoCommit); //恢复场景
			result = "Success";
		} catch (SQLException e) {
			System.out.println(e);
			result = e.toString();
			try {
				if (conn != null){
					conn.rollback();
					conn.setAutoCommit(autoCommit); //恢复场景
				}	
			} catch (Exception eroll) {
				eroll.printStackTrace();
			}finally{
				try{
					pstmt.close();
					conn.close();
				}catch(Exception eclose){
					eclose.printStackTrace();
				}
			}			
		}
		return result;
	}
	
	
	//修改发布单, pan.jing
	public String updateDeliverList(DeliverList dlist){				
		PreparedStatement pstmt = null;
		Connection conn = new ConnectionDB().connectionDB();
		Boolean autoCommit = true;
		String result = null;		
		try {
			autoCommit = conn.getAutoCommit();//获得当前状态
			conn.setAutoCommit(false);  //关闭自动提交功能
			String sql = "update ProcessPlatform..DeliverList set projectId = ?,taskId = ?, title = ?, deliverNo = ?, developer = ?,tester = ?, applicationName = ?, content = ?, comments = ?, createUserId = ? , updateUserId = ?, updateTime = GETDATE() "
					+ "where id = ?";	
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dlist.getProjectId());
			pstmt.setInt(2, dlist.getTaskId());
			pstmt.setString(3, dlist.getTitle());
			pstmt.setString(4, dlist.getDeliverNo());
			pstmt.setInt(5, dlist.getDeveloper());
			pstmt.setInt(6, dlist.getTester());
			pstmt.setString(7, dlist.getApplicationName());
			pstmt.setString(8, dlist.getContent());
			pstmt.setString(9, dlist.getComments());
			pstmt.setInt(10, dlist.getCreateUserId());
			pstmt.setInt(11, dlist.getUpdateUserId());	
			pstmt.setInt(12,  dlist.getId());
			
			pstmt.executeUpdate();
			conn.commit(); 
			conn.setAutoCommit(autoCommit); //恢复场景
			result = "Success";
		} catch (SQLException e) {
			e.printStackTrace();
			result = e.toString();
			try {
				if (conn != null){
					conn.rollback();
					conn.setAutoCommit(autoCommit); //恢复场景
				}	
			} catch (Exception e2) {
				e2.printStackTrace();
			}finally{
				try{
					pstmt.close();
					conn.close();
				}catch(Exception eclose){
					eclose.printStackTrace();
				}
			}			
		}		
		return result;		
	}

	
	//根据centerName查询所有发布单, pan.jing
	public List<DeliverList> queryDeliverListByCenter(String centerName){  
		PreparedStatement pstmt = null;
		Connection conn = new ConnectionDB().connectionDB();
		ResultSet rs = null;
		List<DeliverList> list = new ArrayList<DeliverList>();
		try {
			String sql = "select * from ProcessPlatform..DeliverList where taskId in (select id from ProcessPlatform..Task where projectId in (select id from ProcessPlatform..Project where groupId in (select id from ProcessPlatform..PP_Group where id in (select id from Center where centerName = ?))))";		
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, centerName);			
			rs = pstmt.executeQuery();
			while (rs.next()){
				DeliverList dList = new DeliverList();
				dList.setId(Integer.valueOf(rs.getString("id")));
				dList.setProjectId(Integer.valueOf(rs.getString("projectId")));
				dList.setTaskId(rs.getInt("taskId"));
				dList.setTitle(rs.getString("title"));
				dList.setDeliverNo(rs.getString("deliverNo"));
				dList.setDeveloper(Integer.valueOf(rs.getString("developer")));
				dList.setTester(Integer.valueOf(rs.getString("tester")));
				dList.setApplicationName(rs.getString("applicationName"));
				dList.setContent(rs.getString("content"));
				dList.setComments(rs.getString("comments"));
				dList.setCreateUserId(Integer.valueOf(rs.getString("createUserId")));
				dList.setUpdateUserId(Integer.valueOf(rs.getString("updateUserId")));
				dList.setCreateTime(rs.getString("createTime"));
				dList.setUpdateTime(rs.getString("updateTime"));
				list.add(dList);				
			}			
		} catch (SQLException e) {
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
		return list;				
	}
	
	//根据groupName查询小组所有发布单, pan.jing	
	public List<DeliverList> queryDeliverListByGroup(String groupName){  
		PreparedStatement pstmt = null;
		Connection conn = new ConnectionDB().connectionDB();
		ResultSet rs = null;
		List<DeliverList> list = new ArrayList<DeliverList>();
		try {
			String sql = "select * from ProcessPlatform..DeliverList where taskId in (select id from ProcessPlatform..Task where projectId in (select id from ProcessPlatform..Project where groupId in (select id from ProcessPlatform..PP_Group where groupName = ?)))";		
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, groupName);			
			rs = pstmt.executeQuery();
			while (rs.next()){
				DeliverList dList = new DeliverList();
				dList.setId(Integer.valueOf(rs.getString("id")));
				dList.setProjectId(Integer.valueOf(rs.getString("projectId")));
				dList.setTaskId(rs.getInt("taskId"));
				dList.setTitle(rs.getString("title"));
				dList.setDeliverNo(rs.getString("deliverNo"));
				dList.setDeveloper(Integer.valueOf(rs.getString("developer")));
				dList.setTester(Integer.valueOf(rs.getString("tester")));
				dList.setApplicationName(rs.getString("applicationName"));
				dList.setContent(rs.getString("content"));
				dList.setComments(rs.getString("comments"));
				dList.setCreateUserId(Integer.valueOf(rs.getString("createUserId")));
				dList.setUpdateUserId(Integer.valueOf(rs.getString("updateUserId")));
				dList.setCreateTime(rs.getString("createTime"));
				dList.setUpdateTime(rs.getString("updateTime"));
				list.add(dList);				
			}			
		} catch (SQLException e) {
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
		return list;				
	}
	
	
	//根据id查询单条发布单, pan.jing
	public DeliverList queryDeliverInfoById(int deliverId){  
		PreparedStatement pstmt = null;
		Connection conn = new ConnectionDB().connectionDB();
		ResultSet rs = null;
		DeliverList dList = new DeliverList();
		try {
			String sql = "select * from ProcessPlatform..DeliverList where id = ?";				
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deliverId);			
			rs = pstmt.executeQuery();
			while (rs.next()){				
				dList.setId(Integer.valueOf(rs.getString("id")));
				dList.setProjectId(Integer.valueOf(rs.getString("projectId")));
				dList.setTaskId(rs.getInt("taskId"));
				dList.setTitle(rs.getString("title"));
				dList.setDeliverNo(rs.getString("deliverNo"));
				dList.setDeveloper(Integer.valueOf(rs.getString("developer")));
				dList.setTester(Integer.valueOf(rs.getString("tester")));
				dList.setApplicationName(rs.getString("applicationName"));
				dList.setContent(rs.getString("content"));
				dList.setComments(rs.getString("comments"));
				dList.setCreateUserId(Integer.valueOf(rs.getString("createUserId")));
				dList.setUpdateUserId(Integer.valueOf(rs.getString("updateUserId")));
				dList.setCreateTime(rs.getString("createTime"));
				dList.setUpdateTime(rs.getString("updateTime"));				
			}			
		} catch (SQLException e) {
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
		return dList;						
	}
	

	//根据taskName获取ProjectID和taskID, pan.jing
	public Map<String, Integer> getProAndTaskId(String taskName) {   	
		Connection conn = new ConnectionDB().connectionDB();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Integer> map = new HashMap<String, Integer>();
		String sql = "select id,projectId from ProcessPlatform..Task where taskName = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, taskName);
			rs = pstmt.executeQuery();
			while(rs.next()){
				map.put("taskId", Integer.valueOf(rs.getString("id")));  
				map.put("projectId", Integer.valueOf(rs.getString("projectId")));			
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally{
			try{
				rs.close();
				pstmt.close();
				conn.close();
			}catch(Exception eclose){
				eclose.printStackTrace();
			}
		}	
		return map;			
	}
	

	//根据UserName获得userId, pan.jing
	public int getUserIdByName(String userName) {   	
		Connection conn = new ConnectionDB().connectionDB();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int userId = 0;
		String sql = "select Id from ProcessPlatform..PP_User where UserName = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			rs = pstmt.executeQuery();
			while(rs.next()){
				userId = Integer.valueOf(rs.getString("Id"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally{
			try{
				rs.close();
				pstmt.close();
				conn.close();
			}catch(Exception eclose){
				eclose.printStackTrace();
			}
		}	
		return userId;			
	}
	
	
	//判断发布单号是否存在,pan.jing
		public boolean isExistId(int id){
			boolean b = false;
			Connection conn = new ConnectionDB().connectionDB();	
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "select count(*) as count from ProcessPlatform..DeliverList where id = ?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				rs = pstmt.executeQuery();
				rs.next();
	            int rowCount = rs.getInt("count");
	            if (rowCount > 0){
	            	b = true;
	            }else {
	            	b = false;
				}
			} catch (SQLException e) {
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
			return b;		
		}
	
	
	//测试
/*
	public static void main(String[] args) {
		//DeliverList dList = new DeliverList(11,2, 2, "newTitle", "newDeliverNo", 2, 2, "newapplicationName","newContent", "newComments", 2,2);
		DeliverListDAO dListDAO = new DeliverListDAO();
		//List<DeliverList> list = dListDAO.queryDeliverInfoById(11);//
		DeliverList dList = dListDAO.queryDeliverInfoById(9);
	//	for (int i = 0; i < list.size(); i++) {
			//dList = list.get(i);  
			System.out.println(dList.getId());
			System.out.println(dList.getDeliverNo());
		//}		
	}
*/
		

}

















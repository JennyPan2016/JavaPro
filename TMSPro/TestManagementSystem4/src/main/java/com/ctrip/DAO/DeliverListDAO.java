package com.ctrip.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ctrip.Model.DeliverList;
import com.ctrip.Model.Project;
import com.ctrip.Utility.ConnectionDB;



public class DeliverListDAO {
	
	/*
	 * 新增发布单, pan.jing
	 * */
	public String insertDeliverList(DeliverList dlist) {
		PreparedStatement pstmt = null;
		Connection conn = new ConnectionDB().connectionDB();
		Boolean autoCommit = true;
		String result = null;
		try {
			autoCommit = conn.getAutoCommit();//获得当前状态
			conn.setAutoCommit(false);  //关闭自动提交功能
			String sql = "insert into ProcessPlatform..DeliverList(projectId,taskId,title,deliverNo,developer,tester,content,"
					+ "comments,createUserId,updateUserId,createTime,updateTime,appId,DeliverType,Status)"
					+ " values (?,?,?,?,?,?,?,?,?,?,GETDATE(),GETDATE(),?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, dlist.getProjectId());  
			pstmt.setInt(2, dlist.getTaskId());
			pstmt.setString(3, dlist.getTitle());
			pstmt.setString(4, dlist.getDeliverNo());
			pstmt.setInt(5, dlist.getDeveloperId());
			pstmt.setInt(6, dlist.getTesterId());
			pstmt.setString(7, dlist.getContent());
			pstmt.setString(8, dlist.getComments());
			pstmt.setInt(9, dlist.getCreateUserId());
			pstmt.setInt(10, dlist.getUpdateUserId());	
			pstmt.setString(11, dlist.getAppId());
			pstmt.setString(12, dlist.getDeliverType());
			pstmt.setString(13, dlist.getStatus());
			
			pstmt.executeUpdate();
			conn.commit(); 
			conn.setAutoCommit(autoCommit); //恢复场景
			result = "Success";
		} catch (SQLException e) {
			System.out.println(e);
			result = "添加发布单失败！";
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
	
	
	/*
	 * 修改发布单, pan.jing
	 * */
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
			pstmt.setInt(5, dlist.getDeveloperId());
			pstmt.setInt(6, dlist.getTesterId());
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
	
	
	/*
	 * 删除发布单, pan.jing
	 * */
	public String deleteDeliverList(DeliverList dlist){				
		PreparedStatement pstmt = null;
		Connection conn = new ConnectionDB().connectionDB();
		Boolean autoCommit = true;
		String result = null;		
		try {
			autoCommit = conn.getAutoCommit();//获得当前状态
			conn.setAutoCommit(false);  //关闭自动提交功能
			String sql = "delete from ProcessPlatform..DeliverList where id = ?";				
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dlist.getId());
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
	
	
	/*
	 * 查询发布单, pan.jing
	 */ 
	public List<DeliverList> queryDeliverLists(DeliverList dList,String startTime,String endTime){  
		Connection conn = new ConnectionDB().connectionDB();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<DeliverList> lists = new ArrayList<DeliverList>();
		String sql = "select a.id as deliverListId,a.projectId,a.taskId,a.title,a.deliverNo,a.developer,a.tester,a.content,a.comments,a.createUserId,a.updateUserId,a.createTime,"
				+ "a.updateTime,a.deliverType,a.appId, b.projectName, c.groupName,d.centerName,e.departmentName,f.productName from ProcessPlatform..DeliverList a "
				+ "LEFT JOIN ProcessPlatform..Project b on a.projectId = b.id "
				+ "LEFT JOIN ProcessPlatform..PP_Group c  on b.groupId = c.id "
				+ "LEFT JOIN ProcessPlatform..Center d  on c.centerId = d.id "
				+ "LEFT JOIN ProcessPlatform..Department e  on d.departmentId = e.id  "
				+ "LEFT JOIN ProcessPlatform..Product f on f.groupId = c.id where 1 = 1 ";
		if (dList.getDepartmentName() != null && !dList.getDepartmentName().equals("")) {
	        sql = sql + "and e.departmentName = ? ";
	    }
		if (dList.getCenterName() != null && !dList.getCenterName().equals("")) {
	        sql = sql + "and d.centerName = ? ";
	    }
		if (dList.getGroupName() != null && !dList.getGroupName().equals("")) {
	        sql = sql + "and c.groupName = ? ";
	    }
//		if (dList.getProjectId() != 0) {
//	        sql = sql + "and b.id = ?";
//	    }
		if (startTime != null && !startTime.equals("")) {
	        sql = sql + "and a.createTime >= ? ";
	    }
		if (endTime != null && !endTime.equals("")) {
	        sql = sql + "and a.createTime <= ? ";
	    }
		
		
		try {
			pstmt = conn.prepareStatement(sql);
	        int i = 1;
	        if (dList.getDepartmentName() != null && !dList.getDepartmentName().equals("")) {
	           pstmt.setString(1, dList.getDepartmentName());
	           i++;
	        }
	        if (dList.getCenterName() != null && !dList.getCenterName().equals("")) {
	           pstmt.setString(2, dList.getCenterName());
		       i++;
		    }
			if (dList.getGroupName() != null && !dList.getGroupName().equals("")) {
	           pstmt.setString(3, dList.getGroupName());
		       i++;
		    }
//			if (dList.getProjectId() != 0) {
//	           pstmt.setInt(i, dList.getProjectId());
//		       i++;
//		    }
			if (startTime != null && !startTime.equals("")) {
	           pstmt.setString(4, startTime);
		       i++;
			}
			if (endTime != null && !endTime.equals("")) {
	           pstmt.setString(5, endTime + " 23:59:59");
		       i++;
			}
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				DeliverList dList2 = new DeliverList();
				dList2.setId(rs.getInt("deliverListId"));
				dList2.setProjectId(rs.getInt("projectId"));
				dList2.setTaskId(rs.getInt("taskId"));
				dList2.setTitle(rs.getString("title"));
				dList2.setDeliverNo(rs.getString("deliverNo"));
				dList2.setDeveloperId(rs.getInt("developer"));
				dList2.setTesterId(rs.getInt("tester"));
//				dList2.setApplicationName(rs.getString("application"));  //该字段取消
				dList2.setContent(rs.getString("content"));
				dList2.setComments(rs.getString("comments"));
				dList2.setCreateUserId(rs.getInt("createUserId"));
				dList2.setUpdateUserId(rs.getInt("updateUserId"));
				dList2.setCreateTime(rs.getString("createTime"));
				dList2.setUpdateTime(rs.getString("updateTime"));
				dList2.setAppId(rs.getString("appId"));
				dList2.setDeliverType(rs.getString("deliverType"));
				dList2.setDepartmentName(rs.getString("departmentName"));
				dList2.setCenterName(rs.getString("centerName"));
				dList2.setGroupName(rs.getString("groupName"));
				dList2.setProductName(rs.getString("productName"));
				lists.add(dList2);				
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
		return lists;
	}
	
	
	/*
	 * 判断发布单号是否存在,pan.jing
	 * */
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
	
	
	
/*//测试
	public static void main(String[] args) {
		//DeliverList dList = new DeliverList(11,2, 2, "newTitle", "newDeliverNo", 2, 2, "newapplicationName","newContent", "newComments", 2,2);
		DeliverList dList = new DeliverList();
		dList.setDepartmentName("基础业务研发部");
		dList.setCenterName("用户中心");
		dList.setGroupName("登录注册");
		
		DeliverListDAO dListDAO = new DeliverListDAO();
		//DeliverList dList = null;
		List<DeliverList> list = new ArrayList<DeliverList>();
		list = dListDAO.queryDeliverLists(dList,"2017-04-18", "2017-04-19");
		for (int i = 0; i < list.size(); i++) {
			dList = list.get(i);  
			System.out.println(dList.getId());
			System.out.println(dList.getDeliverNo());
		}		
	}*/


}

















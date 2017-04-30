package com.ctrip.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.JSONArray;
import org.json.JSONObject;

import com.ctrip.Model.DeliverList;
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
			result = e.toString();
			try {
				if (conn != null){
					conn.rollback();
					conn.setAutoCommit(autoCommit); //恢复场景
				}	
			} catch (Exception eroll) {
				eroll.printStackTrace();
			}			
		}finally{
			try{
				pstmt.close();
				conn.close();
			}catch(Exception eclose){
				eclose.printStackTrace();
			}
		}
		return result;
	}
	
	
	/*
	 * 修改发布单, pan.jing
	 * */
	public String updateDeliverList(DeliverList dlist){	
		String result = null;
		if(dlist.getDeveloperId() == 0){
			try {
				throw new Exception("updateDeliverList: 数据格式错误！");
			} catch (Exception e) {
				e.printStackTrace();
				result = e.toString();
			}
		}
		
		PreparedStatement pstmt = null;
		Connection conn = new ConnectionDB().connectionDB();
		Boolean autoCommit = true;				
		try {
			autoCommit = conn.getAutoCommit();//获得当前状态
			conn.setAutoCommit(false);  //关闭自动提交功能
			String sql = "update ProcessPlatform..DeliverList set projectId = ?,taskId = ?, title = ?, deliverNo = ?, developer = ?,"
					+ "tester = ?, content = ?, comments = ?, createUserId = ? , updateUserId = ?, updateTime = GETDATE(),appId = ?, deliverType = ?, status = ? "
					+ "where id = ?";	
			
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
			pstmt.setInt(14,  dlist.getId());
			
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
			}		
		}finally{
			try{
				pstmt.close();
				conn.close();
			}catch(Exception eclose){
				eclose.printStackTrace();
			}
		}			
		return result;		
	}
	
	
	/*
	 * 删除发布单, pan.jing
	 * */
	public String deleteDeliverList(int deliverId){	
		String result = null;
		if(deliverId == 0){
			try {
				throw new Exception("deleteDeliverList: 数据格式错误！");
			} catch (Exception e) {
				e.printStackTrace();
				result = e.toString();
			}
		}
		
		PreparedStatement pstmt = null;
		Connection conn = new ConnectionDB().connectionDB();
		Boolean autoCommit = true;	
		try {
			autoCommit = conn.getAutoCommit();//获得当前状态
			conn.setAutoCommit(false);  //关闭自动提交功能
			String sql = "delete from ProcessPlatform..DeliverList where id = ?";				
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deliverId);
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
			}		
		}finally{
			try{
				pstmt.close();
				conn.close();
			}catch(Exception eclose){
				eclose.printStackTrace();
			}
		}			
		return result;		
	}
	
	
	/*
	 * 查询发布单, pan.jing
	 */ 
	public JSONArray queryDeliverLists(int groupId,String startTime,String endTime,String status){  
		JSONArray jArray = new JSONArray();

		Connection conn = new ConnectionDB().connectionDB();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select a.id as deliverListId,a.projectId,a.taskId,a.title,a.deliverNo,a.developer,a.tester,a.content,a.comments,a.createUserId,a.updateUserId,a.createTime,"
                        + "a.updateTime,a.deliverType,a.appId, a.status from ProcessPlatform..DeliverList a, ProcessPlatform..Project b "
                        + "where a.projectId = b.id and a.status = ? and b.groupId = ? and a.createTime >=? and a.createTime <=?";		
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, status);
			pstmt.setInt(2, groupId);
			pstmt.setString(3, startTime);
			pstmt.setString(4, endTime + " 23:59:59");
			rs = pstmt.executeQuery();
			while(rs.next()){		
				JSONObject jO = new JSONObject();
				jO.put("deliverListId", rs.getInt("deliverListId"));
				jO.put("projectId", rs.getInt("projectId"));				
				jO.put("taskId", rs.getInt("taskId"));
				jO.put("title", rs.getString("title"));
				jO.put("deliverNo", rs.getString("deliverNo"));
				jO.put("developer", rs.getInt("developer"));
				jO.put("tester", rs.getInt("tester"));
				jO.put("content", rs.getString("content"));
				jO.put("comments", rs.getString("comments"));
				jO.put("createUserId", rs.getInt("createUserId"));
				jO.put("updateUserId", rs.getInt("updateUserId"));
				jO.put("createTime", rs.getString("createTime"));
				jO.put("updateTime", rs.getString("updateTime"));
				jO.put("appId", rs.getString("appId"));
				jO.put("deliverType", rs.getString("deliverType"));
				jO.put("status", rs.getString("status"));
				jArray.put(jO);				
			}
			if(jArray.length() == 0){
				JSONObject jO = new JSONObject();
				jO.put("status", "1");
	            jO.put("message", "未查询到数据！");
	            jArray.put(jO);
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
		return jArray;
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

















package com.ctrip.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.JSONArray;
import org.json.JSONObject;

import com.ctrip.Utility.ConnectionDB;

public class BaseQueryDAO {

	/*
	 * 查询所有Department，pan.jing
	 * */	
	public JSONArray queryAllDepartment(){		
		JSONArray jArray = new JSONArray();
		
		Connection conn = new ConnectionDB().connectionDB();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select id as departmentId, departmentName from ProcessPlatform..Department where departmentName is not NULL and departmentName <> ''";				
			pstmt = conn.prepareStatement(sql);		
			rs = pstmt.executeQuery();
			while (rs.next()){
				JSONObject jO = new JSONObject();
				jO.put("departmentId", rs.getString("departmentId"));
				jO.put("departmentName", rs.getString("departmentName"));
				jArray.put(jO);
			}
			if(jArray.length() == 0){
				JSONObject jO = new JSONObject();
				jO.put("status", "1");
	            jO.put("message", "未查询到数据！");
	            jArray.put(jO);
	        }
		}catch (SQLException e) {
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
	
	/*
	 * 查询所有Center，pan.jing
	 * */	
	public JSONArray queryAllCenter(int departmentId){	
		JSONArray jArray = new JSONArray();
		
		Connection conn = new ConnectionDB().connectionDB();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select id as centerId, centerName from ProcessPlatform..Center where departmentId = ?";				
			pstmt = conn.prepareStatement(sql);	
			pstmt.setInt(1, departmentId);
			rs = pstmt.executeQuery();
			while (rs.next()){	
				JSONObject jO = new JSONObject();
				jO.put("centerId", rs.getString("centerId"));
				jO.put("centerName", rs.getString("centerName"));
				jArray.put(jO);
			}
			if(jArray.length() == 0){
				JSONObject jO = new JSONObject();
				jO.put("status", "1");
	            jO.put("message", "未查询到数据！");
	            jArray.put(jO);
	        }
		}catch (SQLException e) {
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
	
	/*
	 * 查询所有group，pan.jing
	 * */	
	public JSONArray queryAllGroup(int centerId){	
		JSONArray jArray = new JSONArray();
	
		Connection conn = new ConnectionDB().connectionDB();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select id as groupId, groupName from ProcessPlatform..PP_Group where centerId = ?";				
			pstmt = conn.prepareStatement(sql);	
			pstmt.setInt(1, centerId);
			rs = pstmt.executeQuery();
			while (rs.next()){	
				JSONObject jO = new JSONObject();
				jO.put("groupId", rs.getString("groupId"));
				jO.put("groupName", rs.getString("groupName"));
				jArray.put(jO);
			}
			if(jArray.length() == 0){
				JSONObject jO = new JSONObject();
				jO.put("status", "1");
	            jO.put("message", "未查询到数据！");
	            jArray.put(jO);
	        }
		}catch (SQLException e) {
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
	
	/*
	 * 查询所有Product，pan.jing
	 * */	
	public JSONArray queryAllProduct(int groupId){	
		JSONArray jArray = new JSONArray();

		Connection conn = new ConnectionDB().connectionDB();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select id as productId, productName from ProcessPlatform..Product where groupId = ?";				
			pstmt = conn.prepareStatement(sql);	
			pstmt.setInt(1, groupId);
			rs = pstmt.executeQuery();
			while (rs.next()){	
				JSONObject jO = new JSONObject();
				jO.put("productId", rs.getString("productId"));
				jO.put("productName", rs.getString("productName"));
				jArray.put(jO);
			}
			if(jArray.length() == 0){
				JSONObject jO = new JSONObject();
				jO.put("status", "1");
	            jO.put("message", "未查询到数据！");
	            jArray.put(jO);
	        }
		}catch (SQLException e) {
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
	
	/*
	 * 查询所有Project，pan.jing
	 * */	
	public JSONArray queryAllProject(int productId ){	
		JSONArray jArray = new JSONArray();

		Connection conn = new ConnectionDB().connectionDB();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select id as projectId, projectName from ProcessPlatform..Project where productId = ?";				
			pstmt = conn.prepareStatement(sql);	
			pstmt.setInt(1, productId);
			rs = pstmt.executeQuery();
			while (rs.next()){	
				JSONObject jO = new JSONObject();
				jO.put("projectId", rs.getString("projectId"));
				jO.put("projectName", rs.getString("projectName"));
				jArray.put(jO);
			}
			if(jArray.length() == 0){
				JSONObject jO = new JSONObject();
				jO.put("status", "1");
	            jO.put("message", "未查询到数据！");
	            jArray.put(jO);
	        }
		}catch (SQLException e) {
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
	
	/*
	 * 查询所有Task，pan.jing
	 * */	
	public JSONArray queryAllTask(int projectId ){	
		JSONArray jArray = new JSONArray();

		Connection conn = new ConnectionDB().connectionDB();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select id as taskId, taskName from ProcessPlatform..Task where projectId = ?";				
			pstmt = conn.prepareStatement(sql);	
			pstmt.setInt(1, projectId);
			rs = pstmt.executeQuery();
			while (rs.next()){	
				JSONObject jO = new JSONObject();
				jO.put("taskId", rs.getString("taskId"));
				jO.put("taskName", rs.getString("taskName"));
				jArray.put(jO);
			}
			if(jArray.length() == 0){
				JSONObject jO = new JSONObject();
				jO.put("status", "1");
	            jO.put("message", "未查询到数据！");
	            jArray.put(jO);
	        }
		}catch (SQLException e) {
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
	
}

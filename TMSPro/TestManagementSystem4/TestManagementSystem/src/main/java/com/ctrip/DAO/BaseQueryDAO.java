package com.ctrip.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ctrip.Model.BaseQuery;
import com.ctrip.Utility.ConnectionDB;

public class BaseQueryDAO {

	/*
	 * 查询所有Department，pan.jing
	 * */	
	public List<BaseQuery> queryAllDepartment(){		
		Connection conn = new ConnectionDB().connectionDB();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BaseQuery> list = new ArrayList<BaseQuery>();
		try {
			String sql = "select id as departmentId, departmentName from ProcessPlatform..Department where departmentName is not NULL and departmentName <> ''";				
			pstmt = conn.prepareStatement(sql);		
			rs = pstmt.executeQuery();
			while (rs.next()){	
				BaseQuery bQuery = new BaseQuery();
				bQuery.setDepartmentId(rs.getString("departmentId"));
				bQuery.setDepartmentName(rs.getString("departmentName"));
				list.add(bQuery);
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
		return list;
	}
	
	/*
	 * 查询所有Center，pan.jing
	 * */	
	public List<BaseQuery> queryAllCenter(int departmentId){		
		Connection conn = new ConnectionDB().connectionDB();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BaseQuery> list = new ArrayList<BaseQuery>();
		try {
			String sql = "select id as centerId, centerName from ProcessPlatform..Center where departmentId = ?";				
			pstmt = conn.prepareStatement(sql);	
			pstmt.setInt(1, departmentId);
			rs = pstmt.executeQuery();
			while (rs.next()){	
				BaseQuery bQuery = new BaseQuery();
				bQuery.setCenterId(rs.getString("centerId"));
				bQuery.setCenterName(rs.getString("centerName"));
				list.add(bQuery);
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
		return list;
	}
	
	/*
	 * 查询所有group，pan.jing
	 * */	
	public List<BaseQuery> queryAllGroup(int departmentId, int centerId){		
		Connection conn = new ConnectionDB().connectionDB();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BaseQuery> list = new ArrayList<BaseQuery>();
		try {
			String sql = "select a.id as groupId, a.groupName from ProcessPlatform..PP_Group a , ProcessPlatform..Center b, ProcessPlatform..Department c where "
					+ "a.centerId = b.id and b.departmentId = c.id and c.id = ? and b.id = ? ";				
			pstmt = conn.prepareStatement(sql);	
			pstmt.setInt(1, departmentId);
			pstmt.setInt(2, centerId);
			rs = pstmt.executeQuery();
			while (rs.next()){	
				BaseQuery bQuery = new BaseQuery();
				bQuery.setGroupId(rs.getString("groupId"));
				bQuery.setGroupName(rs.getString("groupName"));
				list.add(bQuery);
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
		return list;
	}
	
	/*
	 * 查询所有Product，pan.jing
	 * */	
	public List<BaseQuery> queryAllProduct(int departmentId, int centerId, int groupId){		
		Connection conn = new ConnectionDB().connectionDB();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BaseQuery> list = new ArrayList<BaseQuery>();
		try {
			String sql = "select e.id as productId, e.productName from ProcessPlatform..Product e , ProcessPlatform..PP_Group a , ProcessPlatform..Center b, ProcessPlatform..Department c where "
					+ "e.groupid = a.id and a.centerId = b.id and b.departmentId = c.id and c.id = ? and b.id = ? and a.id = ? ";				
			pstmt = conn.prepareStatement(sql);	
			pstmt.setInt(1, departmentId);
			pstmt.setInt(2, centerId);
			pstmt.setInt(3, groupId);
			rs = pstmt.executeQuery();
			while (rs.next()){	
				BaseQuery bQuery = new BaseQuery();
				bQuery.setProductId(rs.getString("productId"));
				bQuery.setProductName(rs.getString("productName"));
				list.add(bQuery);
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
		return list;
	}
	
	/*
	 * 查询所有Project，pan.jing
	 * */	
	public List<BaseQuery> queryAllProject(int centerId, int groupId, int productId ){		
		Connection conn = new ConnectionDB().connectionDB();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BaseQuery> list = new ArrayList<BaseQuery>();
		try {
			String sql = "select id as projectId, projectName from ProcessPlatform..Project where centerId = ? and groupId = ? and productId = ?";				
			pstmt = conn.prepareStatement(sql);	
			pstmt.setInt(1, centerId);
			pstmt.setInt(2, groupId);
			pstmt.setInt(3, productId);
			rs = pstmt.executeQuery();
			while (rs.next()){	
				BaseQuery bQuery = new BaseQuery();
				bQuery.setProjectId(rs.getString("projectId"));
				bQuery.setProjectName(rs.getString("projectName"));
				list.add(bQuery);
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
		return list;
	}
	
	/*
	 * 查询所有Task，pan.jing
	 * */	
	public List<BaseQuery> queryAllTask(int projectId ){		
		Connection conn = new ConnectionDB().connectionDB();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BaseQuery> list = new ArrayList<BaseQuery>();
		try {
			String sql = "select id as taskId, taskName from ProcessPlatform..Task where projectId = ?";				
			pstmt = conn.prepareStatement(sql);	
			pstmt.setInt(1, projectId);
			rs = pstmt.executeQuery();
			while (rs.next()){	
				BaseQuery bQuery = new BaseQuery();
				bQuery.setTaskId(rs.getString("taskId"));
				bQuery.setTaskName(rs.getString("taskName"));
				list.add(bQuery);
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
		return list;
	}
	
	
	
	//测试
	public static void main(String[] args){
		List<BaseQuery> list = new ArrayList<BaseQuery>();
		BaseQuery baseQuery = new BaseQuery();
		BaseQueryDAO bQueryDAO = new BaseQueryDAO();
		list = bQueryDAO.queryAllProduct(1,1,1);
		for (int i = 0; i < list.size(); i++) {
			baseQuery = list.get(i);  
			//System.out.println(baseQuery.getProductName());
			//System.out.println(baseQuery.getGroupName());
			System.out.println(baseQuery.getProductName());
			//System.out.println(baseQuery.getDepartmentName());
		}		
		
	}
	
	
}

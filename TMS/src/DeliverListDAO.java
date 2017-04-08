import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


public class DeliverListDAO {
	
	//新增发布单
	public String addDeliverList(DeliverList dlist) {
		PreparedStatement pstmt = null;
		Connection conn = new DBConnection().dbconn();
		Boolean autoCommit = true;
		String result = null;
		try {
			autoCommit = conn.getAutoCommit();//获得当前状态
			conn.setAutoCommit(false);  //关闭自动提交功能
			String sql = "insert into deliverlist(projectId,taskId,title,deliverNo,developer,tester,applicationName,content,comments,createUser,updateUser,createTime,updateTime)"
					+ " values (?,?,?,?,?,?,?,?,?,?,?,now(),now())";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dlist.getProjectId());  
			pstmt.setInt(2, dlist.getTaskId());
			pstmt.setString(3, dlist.getTitle());
			pstmt.setString(4, dlist.getDeliverNo());
			pstmt.setString(5, dlist.getDeveloper());
			pstmt.setString(6, dlist.getTester());
			pstmt.setString(7, dlist.getApplicationName());
			pstmt.setString(8, dlist.getContent());
			pstmt.setString(9, dlist.getComments());
			pstmt.setString(10, dlist.getCreateUser());
			pstmt.setString(11, dlist.getUpdateUser());	
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
	
	//修改发布单
	public String modifyDeliverList(DeliverList dlist){		
		int deliverId = dlist.getId();  //获取待更新的发布单号	
		PreparedStatement pstmt = null;
		Connection conn = new DBConnection().dbconn();
		Boolean autoCommit = true;
		String result = null;
		try {
			autoCommit = conn.getAutoCommit();//获得当前状态
			conn.setAutoCommit(false);  //关闭自动提交功能
			String sql = "update deliverlist set title = ?, deliverNo = ?, developer = ?,tester = ?, applicationName = ?, content = ?, comments = ?, createUser = ? , updateUser = ?, updateTime = now() "
					+ "where id = ?";			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dlist.getTitle());
			pstmt.setString(2, dlist.getDeliverNo());
			pstmt.setString(3, dlist.getDeveloper());
			pstmt.setString(4, dlist.getTester());
			pstmt.setString(5, dlist.getApplicationName());
			pstmt.setString(6, dlist.getContent());
			pstmt.setString(7, dlist.getComments());
			pstmt.setString(8, dlist.getCreateUser());
			pstmt.setString(9, dlist.getUpdateUser());	
			pstmt.setInt(10, deliverId);
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
	
	//根据创建时间获取发布单ID
	public String getDeliverListId(Date createTime) {   //需要static吗？		
		Connection conn = new DBConnection().dbconn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String deliverId = null;
		String sql = "select id from  DeliverList where createTime = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, createTime);
			rs = pstmt.executeQuery();
			while(rs.next()){
				deliverId = rs.getString("id");	  
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return deliverId;			
	}
	
	//根据发布单ID获取对应的发布信息
		public static Map<String, String> getDeliverInfoById(int deliverId){
			Connection conn = new DBConnection().dbconn();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			Map<String, String> map = new HashMap<String, String>();
			String sql = "select *  from  DeliverList where id = ?";  
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, deliverId);
				rs = pstmt.executeQuery();
				while(rs.next()){
					map.put("projectId", rs.getString("projectId")); //项目ID
					map.put("taskId", rs.getString("taskId")); //任务ID
					map.put("title", rs.getString("title")); //发布单标题
					map.put("deliverNo", rs.getString("deliverNo")); //发布单号
					map.put("developer", rs.getString("developer")); //开发
					map.put("tester", rs.getString("tester")); //测试				
					map.put("applicationName", rs.getString("applicationName")); //应用名称
					map.put("content", rs.getString("content")); //发布内容
					map.put("comments", rs.getString("comments")); //备注	
					map.put("createUser", rs.getString("createUser")); //创建者
					map.put("updateUser", rs.getString("updateUser")); //更新者
					map.put("createTime", rs.getString("createTime")); //创建时间
					map.put("updateTime", rs.getString("updateTime")); //更新时间
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}		
			return map;		
		} 
	
	
	//根据项目名称获取项目ID
	public String getProjectId(String proName) {   	
		Connection conn = new DBConnection().dbconn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String proId = null;
		String sql = "select id from Project where projectName = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, proName);
			rs = pstmt.executeQuery();
			while(rs.next()){
				proId = rs.getString("id");	  
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
		return proId;			
	}
	
	//根据任务名称获取任务ID
	public String getTaskId(String taskName) {   	
		Connection conn = new DBConnection().dbconn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String taskId = null;
		String sql = "select id from Task where taskName = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, taskName);
			rs = pstmt.executeQuery();
			while(rs.next()){
				taskId = rs.getString("id");	  
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
		return taskId;			
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		DeliverList dlist = new DeliverList(3, 3, "4月6日发布", "http://cd.release.ctripcorp.com/#/java/100006727/version?id=442347", "陈雷", "潘婧", "星图服务端（StarAtlasService）", 
				"星图系统首批服务端", "无", "付乐乐","");
			String result = new DeliverListDAO().addDeliverList(dlist);
			System.out.println(result);
	}

}

















import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


public class ListDAO {
	
	//根据ListId获取对应的发布信息
	public static Map<String, String> getListInfo(int id){
		Connection conn = new DBConnection().dbconn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, String> map = new HashMap<String, String>();
		String sql = "select *  from  DeliverList where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				map.put("projectId", rs.getString("projectId")); //项目ID
				map.put("deliverNo", rs.getString("deliverNo")); //发布单号
				map.put("taskId", rs.getString("taskId")); //所属任务
				map.put("title", rs.getString("title")); //所属任务
				map.put("developer", rs.getString("developer")); //开发
				map.put("tester", rs.getString("tester")); //测试				
				map.put("applicationName", rs.getString("applicationName")); //应用名称
				map.put("content", rs.getString("content")); //发布内容
				map.put("comments", rs.getString("comments")); //备注				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return map;		
	} 
	
	//根据创建时间获取ListId
	public static String getListId(Date createTime) {   //需要static吗？		
		Connection conn = new DBConnection().dbconn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String id = null;
		String sql = "select id from  DeliverList where createTime = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, createTime);
			rs = pstmt.executeQuery();
			while(rs.next()){
				id = rs.getString("id");	  
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return id;			
	}
	
	

	public static void insertList(ListForm listForm) throws SQLException{
		PreparedStatement pstmt = null;
		Connection conn = new DBConnection().dbconn();

		try {
			conn.setAutoCommit( false);  //事务
			String sql = "insert into person values (?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, listForm.getProjectId());
			
			conn.commit(); 
			conn.setAutoCommit( true);
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				if (conn != null){
					conn.rollback();
					conn.setAutoCommit(true);
				}	
			} catch (Exception e2) {
				e.printStackTrace();
			}			
		}
	}
	
	public static void updateList(Person p) throws SQLException{
		PreparedStatement pstmt = null;
		Connection conn = new DBConnection().dbconn();
		try {
			String sql = "update person set name =? where id = ?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getName());
			pstmt.setInt(2, p.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close(){
		
	}
	
	public static void main(String[] args) {
		Person p = new Person();
		p.setId(8);
		try {
			ListDAO.updateList(p);			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("update Fail!");
		}
		System.out.println("Success!");

	}

}

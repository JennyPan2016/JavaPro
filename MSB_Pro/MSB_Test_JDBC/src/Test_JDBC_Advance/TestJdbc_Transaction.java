package Test_JDBC_Advance;

//以事务方式提交SQL

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJdbc_Transaction {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/addressdb?useUnicode=true&characterEncoding=UTF-8";
		String user = "root";
		String pwd = "";
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DriverManager.getConnection(url,user,pwd);
		// 事务处理方式	
			conn.setAutoCommit(false); // 取消自动提交功能
			stmt = conn.createStatement();
			stmt.addBatch("insert into address2 values ('3','testname')");
			stmt.addBatch("update address2 set address = 'newName' where id = '2'");
			stmt.executeBatch();  
			conn.commit();  //手动提交
			conn.setAutoCommit(true);  //恢复自动提交的功能
System.out.println("执行成功！");			
		} catch (SQLException e) {
			e.printStackTrace();			
				if (conn != null){   // 出现异常立即回滚
					try {
						conn.rollback(); 
						conn.setAutoCommit(true); //恢复自动提交的功能
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
		}finally{
			try {
				if (stmt != null){
					stmt.close();
					stmt = null;
				}
				if (conn != null){
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

package Test_JDBC_Advance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;



//使用PreparedStatement进行批处理

public class TestJdbc_Batch2 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/addressdb?useUnicode=true&characterEncoding=UTF-8";
		String user = "root";
		String pwd = "";
		try {
			Connection conn = DriverManager.getConnection(url,user,pwd);
			PreparedStatement pstmt = conn.prepareStatement("insert into address2 values (?,?)");
			
			pstmt.setInt(1, 5);
			pstmt.setString(2, "hello");
			pstmt.addBatch();
			
			pstmt.setInt(1, 6);
			pstmt.setString(2, "world");
			pstmt.addBatch();
			
			pstmt.executeBatch();  //执行批处理
System.out.println("执行成功！");
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

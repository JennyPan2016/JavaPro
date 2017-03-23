package Test_JDBC_Advance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// 使用Statement进行批处理

public class TestJdbc_Batch {

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
			Statement stmt = conn.createStatement();
			stmt.addBatch("insert into address2 values ('3','testname')");
			stmt.addBatch("update address2 set address = 'newName' where id = '2'");
			stmt.executeBatch();  //将上面两个DML语句同时执行了
System.out.println("执行成功！");
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

}

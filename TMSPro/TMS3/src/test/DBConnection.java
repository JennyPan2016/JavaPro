package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	
	private static Connection conn = null ;
	
	public Connection dbconn() {
		String url = "jdbc:sqlserver://10.3.6.102:1433;DatabaseName=ProcessPlatform";

		String user = "sa";
		String pwd = "base123!@#";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("类加载失败...");
		}
		
		try {
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库连接失败...");
		}		
		
		return conn;
	}
	
	
	

}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	
	private static Connection conn = null ;
	
	public Connection dbconn() {
		String url = "jdbc:mysql://localhost:3306/tms?useUnicode=true&characterEncoding=UTF-8";
		String user = "root";
		String pwd = "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
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

package Test_JDBC_Basic;
// 功能：查询数据库数据，并打印出来
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJdbc_Query {

	public static void main(String[] args) {
		Connection conn = null; // 写作成员变量，方便后面finally中进行访问
		Statement stat = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/book?useUnicode=true&characterEncoding=UTF-8", "root", "");
			stat = conn.createStatement();
			rs = stat.executeQuery("select * from book.tbl_books");
			while (rs.next()) {
				System.out.println(rs.getString(1) + rs.getString("title"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 关闭资源，关闭顺序：后打开的先关闭
			try {
				if (rs != null) {
					rs.close();
					rs = null; // 垃圾收集器可以随时收回
				}
				if (stat != null) {
					stat.close();
					stat = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}

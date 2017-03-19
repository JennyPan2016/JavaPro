package Test_JDBC_Basic;

//功能：向数据库test的perpson表中插入一条记录

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJdbc_DML {

	public static void main(String[] args) {
		Connection conn = null; // 写作成员变量，方便后面finally中进行访问
		Statement stat = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8", "root", "");
			stat = conn.createStatement();
			String sql = "insert into perpson values ('2','testname','30')";
			stat.executeUpdate(sql);
			System.out.println("成功插入一条数据！");			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 关闭资源，关闭顺序：后打开的先关闭
			try {
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

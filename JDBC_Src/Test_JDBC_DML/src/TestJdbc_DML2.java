// 功能：从命令行输入3个参数，然后向数据库test的perpson表中插入该参数

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJdbc_DML2 {

	public static void main(String[] args) {
		
		Connection conn = null; // 写作成员变量，方便后面finally中进行访问
		Statement stat = null;
		int id = 0;
		String name = null;
		String age = null;
		
		if (args.length < 3){     //命令行参数小于3个，出提示
			System.out.println("请输入三个参数！");
			System.exit(-1);  // 非正常退出
		}
		
		try {
			id = Integer.parseInt(args[0]);    //命令行输入的是String类型的参数，需要转换成Int类型
			name = args[1];
			age = args[2];
		} catch (NumberFormatException n) {
			System.out.println("输入参数类型不正确！");
			System.exit(-1);  
		}

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8", "root", "");
			stat = conn.createStatement();
			String sql = "insert into perpson values (" + id + ",'" + name + "','" + age + "'" + ");";
System.out.println(sql);    //输出sql，便于调试查看
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

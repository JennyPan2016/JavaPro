package Test_JDBC_Advance;

// 功能：使用PreparedStatement来执行SQL。 从命令行输入3个参数，然后向数据库test的perpson表中插入该参数。

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestJdbc_PreparedStatement {

	public static void main(String[] args) {
		
		Connection conn = null; // 写作成员变量，方便后面finally中进行访问
		PreparedStatement pstmt = null;  //使用PreparedStatement来执行SQL
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
//使用 prepareStatement
			String sql = "insert into perpson values (?,?,?)";
			pstmt = conn.prepareStatement(sql);  //【注意】这里是 conn.prepareStatement，不是conn.create...
			pstmt.setInt(1, id); //第一个问号的值设为Int类型，值为33
			pstmt.setString(2, name); //第二个问号的值设为String类型，值为Tom
			pstmt.setString(3, age);  //第三个问号的值设为String类型，值为18
			pstmt.executeUpdate();
			System.out.println("成功插入一条数据！");			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 关闭资源，关闭顺序：后打开的先关闭
			try {
				if (pstmt != null) {
					pstmt.close();
					pstmt = null;
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

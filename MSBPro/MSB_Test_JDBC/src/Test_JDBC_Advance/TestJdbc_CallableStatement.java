package Test_JDBC_Advance;

// 对存储过程进行调用

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class TestJdbc_CallableStatement{

    public static void main(String[] args) throws Exception {

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.1:1521:SXT", "scott", "tiger");
        CallableStatement cstmt = conn.prepareCall("{call p(?, ?, ?, ?)}");
        cstmt.registerOutParameter(3, Types.INTEGER);  // 设置第三个问号为输出参数，输出类型为Int型
        cstmt.registerOutParameter(4, Types.INTEGER);
        cstmt.setInt(1, 3);  //设置第一个问号类型为Int型，值为3
        cstmt.setInt(2, 4);
        cstmt.setInt(4, 5); 
        cstmt.execute();
        System.out.println(cstmt.getInt(3));
        System.out.println(cstmt.getInt(4));
        cstmt.close();
        conn.close();
    }

}

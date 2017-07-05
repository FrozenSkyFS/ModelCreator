package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * 1.数据库每次调用sql语句都会重新创立连接，访问频繁，影响性能 解决方案:连接池 2.sql语句硬编码，不利于项目维护
 * 解决方案:动态访问，利用XML文件 3.resultSet取回结果并映射成Java对象麻烦 解决方案:自动映射
 * 
 */
public class JDBCTest {
	public static void main(String[] args) {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rst = null;
		String url = "jdbc:mysql://localhost:3306/mybatis";
		String user = "root";
		String pwd = "123456";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection(url, user, pwd);
			String sql = "select * from user where username=?";
			ps = c.prepareStatement(sql);
			ps.setString(1, "王五");
			rst = ps.executeQuery();
			while (rst.next()) {
				System.out.println(rst.getString("id") + " "
						+ rst.getString("username"));
			}
		} catch (Exception e) {
			System.out.println("Error occur");
		} finally {
			try {
				rst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

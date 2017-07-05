package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * 1.���ݿ�ÿ�ε���sql��䶼�����´������ӣ�����Ƶ����Ӱ������ �������:���ӳ� 2.sql���Ӳ���룬��������Ŀά��
 * �������:��̬���ʣ�����XML�ļ� 3.resultSetȡ�ؽ����ӳ���Java�����鷳 �������:�Զ�ӳ��
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
			ps.setString(1, "����");
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

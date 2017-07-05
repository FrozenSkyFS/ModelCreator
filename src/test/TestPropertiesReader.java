package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import core.ModelCreator;

public class TestPropertiesReader {

	/*
	 * @Test public void testGetPropertiesMap() throws IOException {
	 * PropertiesReader.getPropertiesMap("/java-xml-type.properties"); }
	 */
	@Test
	public void test() throws Exception {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rst = null;
		String url = "jdbc:mysql://localhost:3306/mybatis";
		String user = "root";
		String pwd = "123456";
		Class.forName("com.mysql.jdbc.Driver");
		c = DriverManager.getConnection(url, user, pwd);
		ModelCreator mc=new ModelCreator(c,"G:/JavaWorkSpace/ModelCreator/src/test");
		mc.create();
	}
}

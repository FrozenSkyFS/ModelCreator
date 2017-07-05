package core;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Pair;

public class DataBaseReader {
	private Connection connection;

	public DataBaseReader(Connection connection){
		this.connection=connection;
	}
	private ResultSet executeSql(String sql){
		Statement stmt=null;
		try {
			stmt = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ResultSet resultSet = null;
		try {
			resultSet = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultSet;
	}
	public List<String> getTableNames(){
		List<String> tableNames=new ArrayList<String>();
		String sql = "SHOW tables";
		ResultSet result=executeSql(sql);
		try {
			while (result.next()) {
				String tableName = result.getString(1);
				tableNames.add(tableName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tableNames;
	}
	public Pair<List<String>,List<String>> getColumnNameAndTypeByPair(String tableName){
		String sql = "SHOW columns from " + tableName;
		ResultSet result = executeSql(sql);
		List<String> names=new ArrayList<>();
		List<String> types=new ArrayList<>();
		try {
			while(result.next()){
				String name = result.getString(1);
				String type = result.getString(2);
				names.add(name);
				types.add(type);
				if(name==null||name==""||type==null||type==""){
					throw new SQLException("Column name or type is empty in table "+tableName);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		return new Pair<List<String>, List<String>>(names,types);
	}
}

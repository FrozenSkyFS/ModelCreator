package entity;

import java.util.ArrayList;
import java.util.List;

import util.Pair;

public class TableInfo {
	private List<Pair<String,String>> columnNameAndType;
	private String tableName;
	
	TableInfo(String tableName,List<Pair<String,String>> columnInfo){
		this.tableName=tableName;
		this.columnNameAndType=columnInfo;
	}
	public TableInfo(String tableName,List<String>names,List<String> types){
		int typesLen=types.size();
		int namesLen=names.size();
		if(typesLen!=namesLen){
			throw new RuntimeException("Number of type and name is not same");
		}
		columnNameAndType=new ArrayList<Pair<String,String>>();
		for(int i=0;i<typesLen;i++){
			columnNameAndType.add(new Pair<String,String>(names.get(i),types.get(i)));
		}
		this.tableName=tableName;
	}
	public String getTableName() {
		return tableName;
	}
	public List<Pair<String,String>> getColumnNameAndType(){
		return columnNameAndType;
	}
}

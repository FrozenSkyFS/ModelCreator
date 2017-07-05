package core;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import util.Pair;
import entity.TableInfo;

public class TableProcessor {
	private String tableName;
	public TableProcessor(String tableName){
		this.tableName=tableName;
	}
	
	public TableInfo makeTableInfo(){
		Pair<List<String>,List<String>> nameAndType=ClassManager.getDataBaseReader().getColumnNameAndTypeByPair(tableName);
		Map<String,String> typeContrast=ClassManager.getTypeContrast();
		List<String> types=nameAndType.getSecond();
		List<String> names=nameAndType.getFirst();
		int size=types.size();
		Pattern pattern = Pattern.compile("([\\w]+)[\\(]?.*$");
		for(int i=0;i<size;i++) {
			String type=types.get(i);
			Matcher matcher = pattern.matcher(type);
			if (matcher.find()) {
				type = matcher.group(1);
				type = type.toUpperCase();
			}
			String javatype = typeContrast.get(type);
			if(javatype==null||javatype==""){
				throw new RuntimeException("Type transform from SQL to JAVA Error");
			}
			types.set(i,javatype);
		}
		return new TableInfo(tableName,names,types);
	}

	
}

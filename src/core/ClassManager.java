package core;

import java.util.Map;

public class ClassManager {
	private static DataBaseReader dataBaseReader;
	private static Map<String,String> typeContrast;
	public static DataBaseReader getDataBaseReader() {
		return dataBaseReader;
	}
	public static Map<String,String> getTypeContrast() {
		return typeContrast;
	}
	public static void setDataBaseReader(DataBaseReader dataBaseReader) {
		ClassManager.dataBaseReader = dataBaseReader;
	}
	public static void setTypeContrast(Map<String, String> typeContrast) {
		ClassManager.typeContrast = typeContrast;
	}
}

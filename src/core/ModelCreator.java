package core;

import java.io.IOException;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;


import entity.TableInfo;

public class ModelCreator {
	private Connection connection;
	private String path;
	public ModelCreator(Connection c,String p){
		this.connection=c;
		this.path=p;
		init();
	}
	public void init(){
		 try {
			ClassManager.setTypeContrast(PropertiesReader.getPropertiesMap("/java-xml-type.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		 ClassManager.setDataBaseReader(new DataBaseReader(connection));
	}

	public void create() throws Exception {
		List<String> tableNames=ClassManager.getDataBaseReader().getTableNames();
		Iterator<String> iter=tableNames.iterator();
		while(iter.hasNext()){
			String name=iter.next();
			TableProcessor processor=new TableProcessor(name);
			TableInfo tableInfo=processor.makeTableInfo();
			FileCreator fileCreator=new FileCreator(path,tableInfo);
			fileCreator.makeClassFile();
		}
		System.out.println("Models made Success");
	}
}

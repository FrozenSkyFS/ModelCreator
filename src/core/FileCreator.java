package core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import util.Pair;
import entity.TableInfo;

public class FileCreator {
	private String path;
	private String tableName;
	private List<Pair<String,String>> columnInfo; 
	public FileCreator(String path,TableInfo tableInfo){
		this.path=path;
		this.tableName=tableInfo.getTableName();
		this.columnInfo=tableInfo.getColumnNameAndType();
	}
	public void makeClassFile() throws IOException{
		String fileLocation=path+"/"+tableName.substring(0,1).toUpperCase()+tableName.substring(1)+".java";
		File f=new File(fileLocation);
		if(f.exists()){
			System.out.println("file " + fileLocation + " is already exist");
			return;
		}
		f.createNewFile();
		writeClassFile(f);	
	}
	private void writeClassFile(File file){
		PrintWriter pw=null;
		try {
			pw=new PrintWriter(file);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("File at "+ file+"is not found");
		}
		
		String head="public class "+tableName.substring(0,1).toUpperCase()+tableName.substring(1)+" {";
		pw.println(head);
		Iterator<Pair<String, String>> iter=columnInfo.iterator();
		while(iter.hasNext()){
			Pair<String,String> nameAndType=iter.next();
			String name=nameAndType.getFirst();
			String type=nameAndType.getSecond();
			String property="\tprivate "+type+" "+name+";";
			pw.println(property);
		}
		pw.println("}");
		pw.close();
		System.out.println(file.getName()+ " at " +file.getAbsolutePath()+" is create");
	}
}

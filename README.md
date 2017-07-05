# ModelCreator
Simple programming which can create model file from database for JAVAEE MVC development
Can create models for all tables in the given database in three step 


How to use:

``` java
//first:make a Connection
Connection c = null;
PreparedStatement ps = null;
ResultSet rst = null;
String url = "jdbc:mysql://localhost:3306/mydatabase";
String user = "root";
String pwd = "123456";
Class.forName("com.mysql.jdbc.Driver");
c = DriverManager.getConnection(url, user, pwd);
//second:construct ModelCreator by Connection and the path where Models are writen to
ModelCreator mc=new ModelCreator(c,"G:/JavaWorkSpace/ModelCreator/src/model");
//thrid:create!
mc.create();
```
output file is like this

``` java
public class User {
	private int id;
	private String username;
	private java.sql.Date birthday;
	private String sex;
	private String address;
}

```

you can add getters and setters by eclipse or other IDE.Type correspondence is defined at "java-xml-type.properties" file

only tested in Mysql;

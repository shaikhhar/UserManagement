package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbConn {
	static String dbhost= "jdbc:postgresql://"+"ec2-23-23-92-204.compute-1.amazonaws.com" + 
			":5432"+"/dauuedfd6kijt7";
	static String user = "opgbbjxqwlcgib";
	static String pw = "3902974fafa22fc18756a369a4e59f86a57aeda498fe8d1ab2e423ef6a9648a4";
	public static Connection getCon() {
	try {
		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection(dbhost,user,pw);
		return con;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	
	}
}

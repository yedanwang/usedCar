package com.hb.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Te {
	
	public static Connection conn = null;

	static {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(
					"jdbc:sqlserver://localhost:1433;DatabaseName=Bishe",
					"wyd", "Bishe");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}

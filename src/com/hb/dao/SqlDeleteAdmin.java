package com.hb.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.hb.util.Te;

public class SqlDeleteAdmin {
	public int DeleteAdmin( String id) throws SQLException {
		
	String sql = "delete from admin where id = '"+id+"'";
	System.out.print(sql);
	Statement statement;
	Connection conn = Te.conn;
	statement = conn.createStatement();
	int rs = statement.executeUpdate(sql);
	System.out.print(rs);
	
		  return rs;
	}
	
}

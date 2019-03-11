package com.hb.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.imut.javabean.*;
import java.sql.*;
import com.hb.util.Te;

public class  SqlUpdateCarStatus {
	public int updateFirst( String id) throws SQLException {
	
	String sql = "update car set status = 1 where name = '"+id+"'";
	System.out.print(sql);
	Statement statement;
	Connection conn = Te.conn;
	statement = conn.createStatement();
	int rs = statement.executeUpdate(sql);
	System.out.print(rs);
	
		  return rs;
	}
	
	public int updatelow( String id) throws SQLException {
		
		String sql = "update car set status = -1 where name = '"+id+"'";
		System.out.print(sql);
		Statement statement;
		Connection conn = Te.conn;
		statement = conn.createStatement();
		int rs = statement.executeUpdate(sql);
		System.out.print(rs);
		
			  return rs;
		}
	
}

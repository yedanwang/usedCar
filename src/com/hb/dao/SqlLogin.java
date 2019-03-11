package com.hb.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.imut.javabean.*;
import java.sql.*;
import com.hb.util.Te;
public class SqlLogin {
	public Users checkLogin(String loginName,String password) throws SQLException {
		Connection conn = Te.conn;
		String sql = "SELECT * FROM users where name = '"+loginName+"' and  password = '"+password+"'";
		
		    Users user = new Users();
			System.out.print(sql);
			Statement statement;
			
				statement = conn.createStatement();
				ResultSet rs = statement.executeQuery(sql);
				//conn.close();
				if(rs.next()) 
				{
					System.out.print(rs.getString(1));
					user.setName(rs.getString(1));
					user.setPassword(rs.getString(1));;
					return user;
					
				}	
				else {return null;}
					
	
}
	
	public Users checkAdminLogin(String loginName,String password) throws SQLException {
		Connection conn = Te.conn;
		String sql = "SELECT * FROM admin where name = '"+loginName+"' and  password = '"+password+"'";
		
		    Users user = new Users();
			System.out.print(sql);
			Statement statement;
			
				statement = conn.createStatement();
				ResultSet rs = statement.executeQuery(sql);
				//conn.close();
				if(rs.next()) 
				{
					System.out.print(rs.getString(1));
					user.setName(rs.getString(1));
					user.setPassword(rs.getString(1));;
					return user;
					
				}	
				else {return null;}
					
	
}
	}

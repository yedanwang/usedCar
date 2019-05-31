package com.hb.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

import com.hb.util.Te;
import com.imut.javabean.Users;
import com.imut.javabean.admin;
public class SqlSelectUsersAndAdmin {
	public List selectAllUsers() throws SQLException { //用户
		Connection conn = Te.conn;
		String sql = "select name,password,dark,phone,address,time from users "; 
		System.out.println(sql);
		Statement statement;
		
		statement = conn.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		//conn.close();
		Vector<Users> usersList = new Vector<Users>(); 
		
		while(rs.next()) 
		{
			Users users = new Users();
			users.setName(rs.getString(1));
			users.setPassword(rs.getString(2));
			users.setDark(rs.getString(3));
			users.setPhone(rs.getString(4));
			users.setAddress(rs.getString(5));
			users.setTime(rs.getString(6));
			usersList.add(users);
		}	
		
		return usersList;			

}	
	public List selectAllAdmin() throws SQLException { //管理员
		Connection conn = Te.conn;
		String sql = "select id,time,phone,address,status from admin "; 
		System.out.println(sql);
		Statement statement;
		statement = conn.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		Vector<admin> usersList = new Vector<admin>(); ;		
		while(rs.next()) 
		{
			admin users = new admin();
			users.setId(rs.getString(1));
			users.setTime(rs.getString(2));
			users.setPhone(rs.getString(3));
			users.setAddress(rs.getString(4));
			users.setStatus(rs.getString(5));
			usersList.add(users);
		}	
		
		return usersList;			

}	
 
}

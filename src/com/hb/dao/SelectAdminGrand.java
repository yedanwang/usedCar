package com.hb.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

import com.hb.util.Te;
import com.imut.javabean.admin;

public class SelectAdminGrand {
	public String selectAdminGrand(String id) throws SQLException { //查询管理员权限
		Connection conn = Te.conn;
		String sql = "select status from admin where id = '"+id+"'";; 
		System.out.println(sql);
		Statement statement;	
		statement = conn.createStatement();
		ResultSet rs = statement.executeQuery(sql);	
		String i = new String();
		while(rs.next())
		{
			System.out.println(rs.getString(1));
			i = rs.getString(1);
		}
		return i;	
    }
}
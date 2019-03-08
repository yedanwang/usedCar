package com.hb.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import com.imut.javabean.*;
import java.sql.*;
import com.hb.util.Te;
public class SqlRegister {
	
	public Boolean IsRegister(String id,String password) throws SQLException
	{
		Connection conn = Te.conn;
		String sqlSelect = "select id from users where id = '"+id+"'";
		String sqlInsert = "insert into  users (id , password) values("+id+","+password+")";
		System.out.print(sqlSelect);
		
	
			Statement statement;
			statement = conn.createStatement();
			ResultSet rsSelect = statement.executeQuery(sqlSelect);
			if(rsSelect.next()) 
				{
				System.out.print("已经存在"+rsSelect.getString(1));
				return false;
				}
			else 
			{
				statement.execute(sqlInsert);
				System.out.print("已经插入");
				return true;
			}
			
		
	     
	}

}

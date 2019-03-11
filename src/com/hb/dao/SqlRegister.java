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
	
	public Boolean IsRegister(String id,String password,String phone,String address) throws SQLException
	{
		Connection conn = Te.conn;
		String sqlSelect = "select name from users where name = '"+id+"'";
		String sqlInsert = "insert into  users (name , password,dark,phone,address) values("+"'"+id+"','"+password+"',0,'"+phone+"','"+address+"')";
		System.out.print(sqlSelect);
		System.out.print(sqlInsert);
	
			Statement statement;
			statement = conn.createStatement();
			ResultSet rsSelect = statement.executeQuery(sqlSelect);
			if(rsSelect.next()) 
				{
				System.out.print("用户名已经存在"+rsSelect.getString(1));
				return false;
				}
			else 
			{
				statement.execute(sqlInsert);
				System.out.print("注册成功");
				return true;
			}
			
		
	     
	}
	public Boolean IsAdminRegister(String id,String password) throws SQLException
	{
		Connection conn = Te.conn;
		String sqlSelect = "select name from admin where name = '"+id+"'";
		String sqlInsert = "insert into  admin (name , password) values("+"'"+id+"','"+password+"')";
		System.out.print(sqlSelect);
		System.out.print(sqlInsert);
	
			Statement statement;
			statement = conn.createStatement();
			ResultSet rsSelect = statement.executeQuery(sqlSelect);
			if(rsSelect.next()) 
				{
				System.out.print("用户名已经存在"+rsSelect.getString(1));
				return false;
				}
			else 
			{
				statement.execute(sqlInsert);
				System.out.print("注册成功");
				return true;
			}
	}
}

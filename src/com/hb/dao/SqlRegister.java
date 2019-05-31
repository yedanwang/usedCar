package com.hb.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.*;
import com.imut.javabean.*;
import java.sql.*;
import com.hb.util.Te;
public class SqlRegister {
	
	public Boolean IsRegister(String id,String password,String phone,String address) throws SQLException
	{
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
         System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
         String time = df.format(new Date());
		Connection conn = Te.conn;
		String sqlSelect = "select name from users where name = '"+id+"'";
		String sqlInsert = "insert into  users (name , password,dark,phone,address,time) values("+"'"+id+"','"+password+"',0,'"+phone+"','"+address+"','"+time+"')";
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
	public Boolean IsAdminRegister(String id,String password,String phone,String address,String status) throws SQLException
	{

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        String time = df.format(new Date());
		Connection conn = Te.conn;
		String sqlSelect = "select id from admin where id = '"+id+"'";
		String sqlInsert = "insert into  admin (id , password,phone,address,status,time) values("+"'"+id+"','"+password+"','"+phone+"','"+address+"','"+status+"','"+time+"')";
		System.out.print(sqlSelect);
		System.out.print(sqlInsert);
	
			Statement statement;
			statement = conn.createStatement();
			ResultSet rsSelect = statement.executeQuery(sqlSelect);
			if(rsSelect.next()) 
				{
				System.out.print("管理员用户名已经存在"+rsSelect.getString(1));
				return false;
				}
			else 
			{
				statement.execute(sqlInsert);
				System.out.print("申请成功");
				return true;
			}
	}
}

package com.hb.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

import com.hb.util.Te;
import com.imut.javabean.Car;
import com.imut.javabean.Chat;
import javax.servlet.http.HttpSession;

public class SqlSelectChat {
	
	public List selectChat(String id1, String id2) throws SQLException {
		Connection conn = Te.conn;
		String sql = "SELECT time , from_id , to_id , chat_content from chat where from_id = '" + id1 + "' and to_id='" + id2 + "' or from_id='" + id2 + "' and to_id='" + id1 + "'" ;
		System.out.println(sql);
		Statement statement;			
		statement = conn.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		
		Vector<Chat> ChatList = new Vector<Chat>(); 
		while(rs.next()) 
		{
			Chat chat = new Chat();
			chat.setTime(rs.getString(1));
			chat.setFromId(rs.getString(2));
			chat.setToId(rs.getString(3));
			chat.setChatContent( rs.getString(4));
			ChatList.add(chat);
		}	
		return ChatList;			
}

	public List selectUnReadChat(String str) throws SQLException {
		Connection conn = Te.conn;
		String sql = "SELECT from_id,max(time) AS time FROM chat where status = '0' and to_id = '"+str+"'  group by from_id ";
		System.out.println(sql);
		Statement statement;
		statement = conn.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		Vector<Chat> chatList = new Vector<Chat>(); ;
		while(rs.next()) 
		{
			Chat chat = new Chat();
			chat.setTime(rs.getString(2));
			chat.setFromId(rs.getString(1));
			chat.setStatus("0");
			chatList.add(chat);;
		}	
		return chatList;			
	}
	
	public Vector selectAllpeopleChat(String id)throws SQLException{
		Connection conn = Te.conn;
		String sql = "select max(time) AS time ,from_id,min(status) AS status from chat where  to_id = '"+id+"' group by from_id ";
		System.out.println(sql);
		Statement statement;
		statement = conn.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		Vector<Chat> chatList = new Vector<Chat>(); ;
		while(rs.next()) 
		{
			Chat chat = new Chat();
			chat.setTime(rs.getString(1));
			chat.setFromId(rs.getString(2));
			chat.setStatus(rs.getString(3));
			chatList.add(chat);;
		}	
		return chatList;	
	}
	public Vector selectAlltoChat(String id)throws SQLException{
		Connection conn = Te.conn;
		String sql = "select max(time) AS time ,to_id,min(status) AS status from chat where  from_id = '"+id+"' group by to_id ";
		System.out.println(sql);
		Statement statement;
		statement = conn.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		Vector<Chat> chatList = new Vector<Chat>(); 
		while(rs.next()) 
		{
			Chat chat = new Chat();
			chat.setTime(rs.getString(1));
			chat.setToId(rs.getString(2));
			chat.setStatus(rs.getString(3));
			chatList.add(chat);;
		}	
		return chatList;	
	}
}


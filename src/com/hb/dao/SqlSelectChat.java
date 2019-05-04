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
		System.out.print(sql);
		Statement statement;			
		statement = conn.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		//conn.close();
		Vector<Chat> ChatList = new Vector<Chat>(); ;
		
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

}

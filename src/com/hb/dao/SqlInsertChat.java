package com.hb.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.text.SimpleDateFormat;
import com.hb.util.Te;

public class SqlInsertChat {
	
	public int insertChat( String from,String to,String content) throws SQLException {
		  
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String time = String.valueOf(df.format(new Date()));// new Date()为获取当前系统时间
		String sql = "insert into chat (time,from_id,to_id,chat_content) values ('"+time+"','"+from +"','"+to+"','"+content+"')";
		System.out.print(sql);
		Statement statement;
		Connection conn = Te.conn;
		statement = conn.createStatement();
		int rs = statement.executeUpdate(sql);
		System.out.print(rs);
	    return rs;
	}

}

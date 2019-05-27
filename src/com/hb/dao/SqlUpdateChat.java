package com.hb.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.hb.util.Te;

public class SqlUpdateChat {
	public int updateStatus( String from_id,String to_id) throws SQLException {
		String sql = "update chat set status = 1  where from_id = '" + from_id + "' and to_id='" + to_id + "'" ;
		System.out.print(sql);
		Statement statement;
		Connection conn = Te.conn;
		statement = conn.createStatement();
		int rs = statement.executeUpdate(sql);
		System.out.print(rs);
		
			  return rs;
		}
}

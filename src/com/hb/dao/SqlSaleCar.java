package com.hb.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import com.hb.util.Te;
import com.imut.javabean.Car;

public class SqlSaleCar {
	public Boolean IsSaleInfo(Car car) throws SQLException
	{
		Connection conn = Te.conn;
		String sqlInsert = "insert into  car (name,buy_time,vehicle_type," +
				"mileage,price,status,condition," +
				"car_brand) values('"+car.getName()+"',"+"'"+car.getBuy_time()+"'"+","
				+"'"+car.getVehicle_type()+"'"+","+car.getMileage()+","+car.getPrice()+","+car.getStatus()+","+"'"+car.getCondition()+"'"+",'"+car.getCar_brand()+"')";
		 System.out.print(sqlInsert);
		 Statement statement;
		 statement = conn.createStatement();
		 statement.execute(sqlInsert);
		 System.out.print("����ɹ�");
		 return true;			     
	}

}

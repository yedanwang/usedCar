package com.hb.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

import com.hb.util.Te;
import com.imut.javabean.Car;

public class SqlSelectCar {
	public List selectALLCar() throws SQLException {
		Connection conn = Te.conn;
		String sql = "SELECT car.name,buy_time,vehicle_type,mileage,price,address,condition,phone,car_brand,id FROM car,users where users.name=car.name and status = '1'";
			System.out.print(sql);
			Statement statement;
			
				statement = conn.createStatement();
				ResultSet rs = statement.executeQuery(sql);
				//conn.close();
				Vector<Car> carList = new Vector<Car>(); ;
				
				while(rs.next()) 
				{
					Car car = new Car();
					car.setName(rs.getString(1));
					car.setBuy_time(rs.getString(2));
					car.setVehicle_type(rs.getString(3));
					car.setMileage(Float.parseFloat ( rs.getString(4)));
					car.setPrice(Float.parseFloat( rs.getString(5)));
					car.setAdress(rs.getString(6));
					car.setCondition(rs.getString(7));
					car.setIphone(rs.getString(8));
					car.setCar_brand(rs.getString(9));
					car.setId( Integer.parseInt(rs.getString(10)));
					System.out.print("ID="+car.getId());
					carList.add(car);
				}	
				
				return carList;			
	
}

	public List selectOrderCar(String str) throws SQLException {
		Connection conn = Te.conn;
		String sql = "SELECT * FROM car where status = '1' and vehicle_type like '%"+str+"%' or car_brand like '%"+str+"%'";
		System.out.print(sql);
		Statement statement;
		statement = conn.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		Vector<Car> carList = new Vector<Car>(); ;
		while(rs.next()) 
		{
			Car car = new Car();
			car.setName(rs.getString(1));
			car.setBuy_time(rs.getString(2));
			car.setVehicle_type(rs.getString(3));
			car.setMileage(Float.parseFloat ( rs.getString(4)));
			car.setPrice(Float.parseFloat( rs.getString(5)));
			car.setCondition(rs.getString(7));
			car.setCar_brand(rs.getString(8));
			carList.add(car);;
		}	
		return carList;			
	}
	
	public List selectAllOrderCar() throws SQLException { //管理员查询所有在售车辆
		Connection conn = Te.conn;
		String sql = "SELECT car.name,buy_time,vehicle_type,mileage,price,condition,car_brand,address,phone FROM car,users where status = '1' and users.name=car.name";
		System.out.print(sql);
		Statement statement;
		statement = conn.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		Vector<Car> carList = new Vector<Car>(); ;
		while(rs.next()) 
		{
			Car car = new Car();
			car.setName(rs.getString(1));
			car.setBuy_time(rs.getString(2));
			car.setVehicle_type(rs.getString(3));
			car.setMileage(Float.parseFloat ( rs.getString(4)));
			car.setPrice(Float.parseFloat( rs.getString(5)));
			car.setCondition(rs.getString(6));
			car.setCar_brand(rs.getString(7));
			car.setAdress(rs.getString(8));
			car.setIphone(rs.getString(9));
			carList.add(car);;
		}	
		return carList;			
	}

	public List selectCityCar(String str) throws SQLException { //需要改sql
		Connection conn = Te.conn;
		String sql = "SELECT * FROM car where status = '1' and address like '%"+str+"%'";
		System.out.print(sql);
		Statement statement;
		statement = conn.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		Vector<Car> carList = new Vector<Car>(); ;
		while(rs.next()) 
		{
			Car car = new Car();
			car.setName(rs.getString(1));
			car.setBuy_time(rs.getString(2));
			car.setVehicle_type(rs.getString(3));
			car.setMileage(Float.parseFloat ( rs.getString(4)));
			car.setPrice(Float.parseFloat( rs.getString(5)));
			car.setAdress(rs.getString(7));
			car.setCondition(rs.getString(8));
			car.setIphone(rs.getString(9));
			car.setCar_brand(rs.getString(10));
			carList.add(car);;			
		}	
		return carList;			
}
	public List selectSubmitCar() throws SQLException { //管理员
		Connection conn = Te.conn;
		String sql = "SELECT car.name,buy_time,vehicle_type,mileage,price,address,condition,phone,car_brand FROM car,users where users.name=car.name and status = '0'"; 
		System.out.print(sql);
		Statement statement;
		
		statement = conn.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		//conn.close();
		Vector<Car> carList = new Vector<Car>(); ;
		
		while(rs.next()) 
		{
			Car car = new Car();
			car.setName(rs.getString(1));
			car.setBuy_time(rs.getString(2));
			car.setVehicle_type(rs.getString(3));
			car.setMileage(Float.parseFloat ( rs.getString(4)));
			car.setPrice(Float.parseFloat( rs.getString(5)));
			car.setAdress(rs.getString(6));
			car.setCondition(rs.getString(7));
			car.setIphone(rs.getString(8));
			car.setCar_brand(rs.getString(9));
			carList.add(car);
		}	
		
		return carList;			

}	
	
	public Car selectCarDetail(String str) throws SQLException { //需要改sql
		Connection conn = Te.conn;
		String [] s = str.split("=");
		String sql = "SELECT car.name,buy_time,vehicle_type,mileage,price,address,condition,phone,car_brand,id FROM car,users where users.name=car.name and id = '"+s[1]+"'"; 
		System.out.print(sql);
		Statement statement;
		statement = conn.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		Car car = new Car();
		while(rs.next()) {
			car.setName(rs.getString(1));
			car.setBuy_time(rs.getString(2));
			car.setVehicle_type(rs.getString(3));
			car.setMileage(Float.parseFloat ( rs.getString(4)));
			car.setPrice(Float.parseFloat( rs.getString(5)));
			car.setAdress(rs.getString(6));
			car.setCondition(rs.getString(7));
			car.setIphone(rs.getString(8));
			car.setCar_brand(rs.getString(9));
			car.setId( Integer.parseInt(rs.getString(10)));		
	    }
		return car;	
}
}

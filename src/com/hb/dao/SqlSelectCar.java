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
		String sql = "SELECT * FROM car where status = '1'";
		
		    
			System.out.print(sql);
			Statement statement;
			
				statement = conn.createStatement();
				ResultSet rs = statement.executeQuery(sql);
				//conn.close();
				Vector<Car> carList = new Vector<Car>(); ;
				
				while(rs.next()) 
				{
					
					Car car = new Car();
					//System.out.print(rs.getString(1));
					System.out.print(rs.getString(2));
					car.setId(rs.getString(1));
					car.setBuy_time(rs.getString(2));
					car.setVehicle_type(rs.getString(3));
					//car.setMileage(Float.parseFloat ( rs.getString(4)));
					//car.setPrice(Float.parseFloat( rs.getString(5)));
					car.setAdress(rs.getString(7));
					car.setCondition(rs.getString(8));
					car.setIphone(rs.getString(9));
					System.out.println("carIphone"+car.getIphone());
					carList.add(car);;
								
				}	
				
				return carList;			
	
}

}

package org.servlet;


import com.hb.dao.*;
import com.imut.javabean.*; 
import com.hb.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class selectAllCarServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */

	public selectAllCarServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 SqlSelectCar t = new SqlSelectCar();
	        List<Car> carList = null;
			try {
		    
				carList = t.selectOrderCar((String)request.getAttribute("search"));
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("carList", carList);
			request.getRequestDispatcher("error.jsp").forward(request, response);
		
       
	}	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	       
	}
	public void init() throws ServletException {
		// Put your code here
	}

}

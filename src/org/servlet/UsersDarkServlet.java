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


public class UsersDarkServlet extends HttpServlet {

	public UsersDarkServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 SqlUpdateUsers t = new  SqlUpdateUsers(); 
		 PrintWriter pw = response.getWriter();
			int i;
			String id = ((String)request.getParameter("id")).trim();
			try {
			  i = t.updateDark(id);
			System.out.print("i = "+i);	
			pw.println(i);	
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	       
	}

	public void init() throws ServletException {
		
	}

}

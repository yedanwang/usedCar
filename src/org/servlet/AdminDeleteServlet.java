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


public class AdminDeleteServlet extends HttpServlet {

	public AdminDeleteServlet() {
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
		HttpSession session = request.getSession();
		 SqlDeleteAdmin t = new SqlDeleteAdmin(); 
		 SelectAdminGrand g = new SelectAdminGrand();
		 String id = ((String)request.getParameter("id")).trim();
		 try {
			 System.out.print("&&&&&&&&&&&"+g.selectAdminGrand((String)session.getAttribute("AdminloginName")).equals("1"));

			if(g.selectAdminGrand((String)session.getAttribute("AdminloginName")).equals("1")) 
			{
				PrintWriter pw = response.getWriter();
				int i;			
				i = t.DeleteAdmin(id);
				System.out.print("i = "+i);	
				pw.println(i);	
			 }
			else
			{
				PrintWriter pw = response.getWriter();
				pw.println("2");			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
	}

	public void init() throws ServletException {
		
	}

}

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


public class InsertChatServlet extends HttpServlet {

	
	public InsertChatServlet() {
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
	SqlInsertChat insertChat = new SqlInsertChat();
	
	PrintWriter pw = response.getWriter();	
	try {
		int is = 0;
		is = insertChat.insertChat((String)session.getAttribute("loginName"), request.getParameter("to").trim(),request.getParameter("content").trim() );
		pw.println(is);	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();	
	}
	
	}

	
	public void init() throws ServletException {
		
	}

}

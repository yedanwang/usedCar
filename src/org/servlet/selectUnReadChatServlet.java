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


public class selectUnReadChatServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */

	public selectUnReadChatServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset = utf-8");
		HttpSession session = request.getSession();
		 SqlSelectChat t = new SqlSelectChat();
	        List<Chat> chatList = null;
			try {
		    
				chatList = t.selectUnReadChat( (String)session.getAttribute("loginName"));
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("chatList", chatList);
			request.getRequestDispatcher("error.jsp").forward(request, response);
		
       
	}	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	       
	}
	public void init() throws ServletException {
		// Put your code here
	}

}

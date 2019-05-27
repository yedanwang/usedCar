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


public class selectChatServlet extends HttpServlet {

	
	public selectChatServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset = utf-8");
		HttpSession session = request.getSession();
		SqlSelectChat c = new SqlSelectChat();
		SqlUpdateChat update = new SqlUpdateChat();
		 List<Chat> chatList = null;
		 PrintWriter pw = response.getWriter();
			try {
				chatList = c.selectChat(((String)request.getParameter("id")).trim(), (String)session.getAttribute("loginName"));
				update.updateStatus(((String)request.getParameter("id")).trim(), (String)session.getAttribute("loginName"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 pw.print("{\"data\":[");
			 int i = 0;
			for(Chat chat:chatList)
			{	
				pw.print("{\"time\":\""+chat.getTime().trim()+"\", \"from\":\""+chat.getFromId().trim()+"\", \"to\":\""+chat.getToId().trim()+"\", \"content\":\""+chat.getChatContent().trim()+"\"}");	
				if (i!= chatList.size()-1) {
					pw.print(",");
				}
				i++;
				System.out.print(chatList.size());	
			    
			}
			
			//request.setAttribute("chatList", chatList);
			//request.getRequestDispatcher("error.jsp").forward(request, response);
			 pw.print("]}");
			 
	}

	
	public void init() throws ServletException {
		
	}

}

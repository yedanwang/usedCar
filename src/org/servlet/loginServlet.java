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


public class loginServlet extends HttpServlet {

	
	public loginServlet() {
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
		response.setContentType("text/html;charset = utf-8");
		    String loginName = request.getParameter("loginName").trim();
	        String password = request.getParameter("password");
	     System.out.println("用户名和密码分别为："+loginName+","+password);
	        SqlLogin t = new SqlLogin();
	        Users u;
			try {
				u = t.checkLogin(loginName, password);
				if(u!=null&&u.getDarke().trim().equals("1"))
				{
					PrintWriter pw = response.getWriter();
					pw.println("<script>alert('由于非法操作，该用户已被加入黑名单'); location.href='../../UsedCar/login.jsp';</script>");
				}
				if(u!=null&&u.getDarke().trim().equals("0"))
				{
					HttpSession session = request.getSession();
					session.setAttribute("loginName", loginName);
					System.out.println("session:"+session.getAttribute("loginName"));
					response.sendRedirect("index.jsp");	
				}
				
				else
				{
					PrintWriter pw = response.getWriter();
					pw.println("<script>alert('用户名或密码错误，请检查'); location.href='../../UsedCar/login.jsp';</script>");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

	
	public void init() throws ServletException {
		
	}

}

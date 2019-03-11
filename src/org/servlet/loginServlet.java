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

	/**
	 * Constructor of the object.
	 */

	public loginServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
       
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
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
				if(u!=null)
				{
					HttpSession session = request.getSession();
					session.setAttribute("loginName", loginName);
					System.out.println("session:"+session.getAttribute("loginName"));
					response.sendRedirect("index.jsp");	
					//request.getRequestDispatcher("error.jsp").forward(request,response);
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

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}

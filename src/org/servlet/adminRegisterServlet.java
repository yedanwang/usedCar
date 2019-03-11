package org.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hb.dao.SqlLogin;
import com.hb.dao.SqlRegister;
import com.imut.javabean.Users;


	public class adminRegisterServlet extends HttpServlet {

		/**
		 * Constructor of the object.
		 */

		public adminRegisterServlet() {
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
		     
		        SqlRegister r = new SqlRegister();
				try {
					if(r.IsAdminRegister(loginName, password))
					{
						HttpSession session = request.getSession();
						session.setAttribute("loginName", loginName);
						PrintWriter pw = response.getWriter();
						pw.println("<script>alert('ע��ɹ�'); location.href='../../UsedCar/index.jsp';</script>");
					}
					
					else
					{
					    response.sendRedirect("error.jsp");
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



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


	public class RegisterServlet extends HttpServlet {

		/**
		 * Constructor of the object.
		 */

		public RegisterServlet() {
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
		        String phone = request.getParameter("phone");
		        String address = request.getParameter("address");
		        SqlRegister r = new SqlRegister();
				try {
					PrintWriter pw = response.getWriter();
					if(r.IsRegister(loginName, password, phone, address))
					{
						HttpSession session = request.getSession();
						session.setAttribute("loginName", loginName);		
						pw.println("<script>alert('注册成功'); location.href='../../UsedCar/index.jsp';</script>");
					}
					
					else
					{
						pw.println("<script>alert('用户名已存在'); location.href='../../UsedCar/register.jsp';</script>");
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



package org.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.hb.dao.SqlSaleCar;
import com.imut.javabean.Car;
 

public class PictureServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//req.getRequestDispatcher("/WEB-INF/upfile.jsp").forward(req, resp);
		
	}
 
	/**
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
 
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset = utf-8");
		// ��ȡ Session
		HttpSession session = request.getSession();
		String loginName = (String)session.getAttribute("loginName");
		System.out.println("picture session:"+session.getAttribute("loginName"));
		
		
		Car car = new Car();
		// �ϴ�
		try {
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if (isMultipart) {
				FileItemFactory factory = new DiskFileItemFactory();
				
				ServletFileUpload upload = new ServletFileUpload(factory);
				List<FileItem> items = upload.parseRequest(request);
				Iterator<FileItem> iter = items.iterator();
				while(iter.hasNext()) {
					FileItem item = iter.next();
					//�ж��Ƿ����ͨ�ֶ�
					if (item.isFormField()) {
						String name = item.getFieldName() ;
						String value = item.getString("UTF-8");
						car.set(name, value);
					} else {
						// wenjianshangchuan
						// �ļ���
						String fileFieldName = item.getFieldName();
						String fileName = item.getName();
						// ��ȡ�ļ�����
						String path = "F:\\tmp";
						File file = new File(path,loginName + '_' + fileFieldName+".jpg");
						item.write(file);
						System.out.print("�ļ��ϴ�����");
//						System.out.print(fileFieldName);

					}
					
				}
			} else {
				System.out.print("������������ϵͳ�˳�");
				return;
			}
		} catch(FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		car.setId((String)session.getAttribute("loginName"));		
		car.setStatus("0");
		 SqlSaleCar s = new SqlSaleCar();
		 try {
			s.IsSaleInfo(car);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

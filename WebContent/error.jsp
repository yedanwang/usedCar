<%@ page contentType="text/html;charset=gb2312"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.hb.dao.*"%>
<%@ page import="com.imut.javabean.*"%>
<html>
	<head>
		<title>My JSP 'jdbcForSqlServer2005Test.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	</head>
	<body>
		<p>用户名和密码不正确！</p>
		<a>请重新输入！</a>
		<%
		 SqlSelectCar t = new SqlSelectCar();
        List<Car> carList = null;
		try {
	    
			carList = t.selectALLCar();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Car car:carList)
		{out.write(car.getBuy_time());%>
			<br>
			<% out.write(car.getIphone());
		}
		%>
		
	</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.hb.dao.*"%>
<%@ page import="com.imut.javabean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>二手车</title>
<style>
body{
	margin: 0;
	padding: 0;
	font-size:10px;
}
a{
	text-decoration: none;
}
a:visited{
	color: #000;
}
#page{
	background:#FFF;	
}
#header{
	border-bottom:1px solid #ccc;
	padding: 10px 60px;
	text-align: right;
}
#header span:hover{
	color:#ff552e;
	cursor:pointer;
}
#headpic{
	margin: 30px 0;
	text-align: center;
}
#search-bar{
	width: 700px;
	border:2px solid #ff552e;
	line-height: 38px;
	height: 38px;
	text-align: center;
}
#search-bar input{
	border: none;
	line-height: 38px;
	height: 34px;
	width: 500px;
	outline:none;
}
#search-bar{
	text-align: center;
	margin: auto;
} 
</style>
</head>
<body>
	<div id="page">
		<div id="header">
			<a href="login.jsp"><span>登录</span></a> /
			<a href="register.jsp"><span>注册</span></a>
			<span>个人中心</span>	
			<span>切换城市</span>	
			<a href="sale.jsp"><span>我要卖车</span></a>		
		</div>

		<div id="search">
			<div id="headpic">
				<img src="images/headpicture.jpg" title="车之家" alt="车之家" width="252" height="42">
			</div>
			<div id="search-bar">
				<input type="text" name="select">
				<div style='float:right; padding:0 30px; background: #ff552e; font-size: 20px; color: #fff; cursor: pointer; user-select: none;'>
					搜车源
				</div>
			</div>
		</div>
		<div id="milsearch">
			<dl class="clearfix">
				<dt >品牌</dt>
				<dd class="selectTag1">
				<a href=>大众</a>
				</dd>
			</dl>
		</div>
	</div>
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
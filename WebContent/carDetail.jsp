<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.hb.dao.*"%>
<%@ page import="com.imut.javabean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%String ctxPath=request.getContextPath(); %>

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>车辆详情</title>
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
.hover-to-pointer:hover{
	cursor: pointer;
}
.hover-to-shadow:hover{
	box-shadow: 0 0 10px #888;
}
#page{
	background:#eee;	
}
#header{
	border-bottom:1px solid #ccc;
	padding: 10px 60px;
	text-align: right;
	background: #fff;
}
#header span:hover{
	color:#ff552e;
	cursor:pointer;
}
.detail{
	width: 1400px;
	margin: auto;
	background: #fff;
	overflow: hidden;
	padding: 15px 20px;
	margin-top: 50px;
}
.detail-body{
	margin-top: 50px;
}
.detail-body-left{
	width: 600px;
	float: left;
}
.detail-body-right{
	width: 700px;
	float: left;
	margin-left: 50px;
}
.detail-title{
	font-size: 24px;
	margin-bottom: 20px;
	margin-top: 30px;
}
.orange{
	color: #ff552e;
}
.price-desc{
	font-size: 31px;
}
.price{
	font-size: 44px;
	font-weight: bold;
}
.condition{
	margin-top: 40px;
	font-size: 20px;
}
.condition-kuang{
	float: left;
	width: 24%;
	text-align: center;
	border-right: 1px solid #ccc;
}
.condition-kuang-desc{
	color: #9b9b9b;
	font-size: 16px; 
}
.footer{
	line-height: 50px;
	text-align: center;
}
.left{
	float: left;
}
.half{
	width: 45%;
	margin: 0 2.5%;
}
.phone{
	background: #ff552e;
	color: white;
}
.chat{
	background: #21B2EE;
	color: white;
}
.big-button{
	font-size: 24px;
	padding: 30px 0;
	text-align: center;
}
.big-button i{
	margin-right: 10px;
}
.chat{
	letter-spacing: 15px;
}
.sell-title{
	color: #777;
	font-size: 14px;
}
.sell{
	margin-top: 10px;
}
.sell>div{
	margin-top: 10px;
}
</style>
</head>
<body>
<div id='page'>
	<div id="header">
		<%if ((String)session.getAttribute("loginName") == null){%>
		<a href="login.jsp"><span>登录</span></a> /
		<a href="register.jsp"><span>注册</span></a> 
		<% }else{%>
		<span onclick="location.href='exit.jsp'">欢迎你：
		<% 
			String name = (String)session.getAttribute("loginName") ;
		        out.print(name);}
		%></span>
		<span>个人中心</span>	
		<!-- <span>切换城市</span>	 -->
		<a href="sale.jsp"><span>我要卖车</span></a>		
	</div>
	<%
		 SqlSelectCar t = new SqlSelectCar();
       Car car = new Car();
		try {
			String path = request.getQueryString();
			car = t.selectCarDetail(path);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}%>
	<div class="detail">
		<div class="detail-title">
			本田 CRV 2010款 2.0L 自动四驱经典版
		</div>
		<div class="detail-body">
			<div class="detail-body-left">
			<%String picSrc = "upload/"+car.getName().trim()+"_carImg.jpg";%>
				<img src='<% out.write(picSrc); %>' width="600px">
			</div>
			<div class="detail-body-right">
				<div class='price'>
					<span class='orange price-desc'>￥</span><span class="orange price"><% out.write(String.valueOf(car.getPrice())); %></span><span class='orange price-desc'>万</span>
				</div>
				<div class='condition'>
					<div style="overflow: hidden;">
						<div class='condition-kuang'>
							<div>	<% out.write(String.valueOf(car.getMileage())); %></div>
							<div class='condition-kuang-desc'>表显里程</div>
						</div>
						<div class='condition-kuang'>
							<div>	<% out.write(car.getBuy_time()); %></div>
							<div class='condition-kuang-desc'>购买时间</div>
						</div>
						<div class='condition-kuang'>
							<div>	<% out.write(car.getCar_brand()); %></div>
							<div class='condition-kuang-desc'>品牌</div>
						</div>
						<div class='condition-kuang' style="border: none;">
							<div>	<% out.write(car.getVehicle_type()); %></div>
							<div class='condition-kuang-desc'>车型</div>
						</div>
					</div>
					<div style='border-top: 1px solid #ccc; margin-top: 20px; padding: 10px;'>
						<div>车辆描述：<% out.write(car.getCondition()); %></div>
					</div>
					<div style="margin-top: 25px; overflow: hidden;">
						<div class='left half phone big-button'><i class="fas fa-phone"></i><% out.write(car.getIphone()); %></div>
						<div class='left half chat big-button' onclick="window.open('chat.jsp?to=<% out.write(car.getName());  %>')"><i class="far fa-comment-dots"></i>微聊</div>
					</div>
					<div class="sell">
						<div><span class="sell-title">卖家：</span><% out.write(car.getName()); %></div>
						<div><span class="sell-title">看车地址：</span><% out.write(car.getAdress()); %></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class='footer'>
		&copy;王二傻,齐大傻  版权所有
	</div>
</div>
</body>
</html>

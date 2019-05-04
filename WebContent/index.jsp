<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.hb.dao.*"%>
<%@ page import="com.imut.javabean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>二手车</title>
<link rel="stylesheet" href="static/css/swiper.min.css" type="text/css"/>
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
	width: 550px;
	outline:none;
}
#search-bar{
	text-align: center;
	margin: auto;
} 
.swiper-container{
	/*轮播图高度*/
	height: 300px;
	background: #ddd;
	text-align: center;
	margin-top: 30px;
}
.column-title{
	width: 890px;
	font-weight: blod;
	font-size: 20px;
	text-align: left;
	padding: 5px;
	border-bottom: 1px solid #ccc;
	margin:30px auto 0 auto;
}
.car-content{
	width: 900px;
	margin-left: auto;
	margin-right: auto;
	margin-top: 30px;
	overflow: hidden;
}

.car-content-detail{
	width: 180px;
	height: 300px;
	border: 1px solid #ddd;
	text-align:center;
	padding: 10px;
	float: left;
	margin-left: 30px;
	margin-bottom: 30px;
}

.car-content-detail:nth-child(4n+1){
	margin-left: 1px;
}
.car-content-detail img{
	width: 180px;
	height: 140px;
	box-shadow: 0 0 10px #888888;
	margin-top: 10px;
}
.car-content-detail-text{
	margin-top: 20px;
	color: #888;
	text-align: center;
}
.car-detail-price{
	color: red;
	font-size: 30px;
	margin-top: 50px;
	padding: 20px 0;
	border-top: 1px solid #aaa;
}
footer{
	background: #ff552e;
	height: 35px;
	line-height: 35px;
	font-size: 20px;
	color: #eee;
	text-align: center;
}
</style>
</head>
<body>
	<div id="page">
		<div id="header">
		<%if ((String)session.getAttribute("loginName") == null){%>
		<a href="login.jsp"><span>登录</span></a> /
			<a href="register.jsp"><span>注册</span></a> 
		<% }else{%><span onclick="location.href='exit.jsp'">欢迎你：
<% 
	String name = (String)session.getAttribute("loginName") ;
        out.print(name);}
%></span>
			
			<span>个人中心</span>	
			<!-- <span>切换城市</span>	 -->
			<a href="sale.jsp"><span>我要卖车</span></a>		
		</div>

		<div id="search">
			<div id="headpic">
				<img src="images/headpicture.jpg" title="车之家" alt="车之家" width="252" height="42">
			</div>
			<div id="search-bar">
				<form id="search-form" action="search.jsp" method="get">
					<input type="text" name="search">
					
					<div style='float:right; padding:0 30px; background: #ff552e; font-size: 20px; color: #fff; cursor: pointer; user-select: none;'
					onclick="search()">
						搜车源
					</div>
				</form>
			</div>
		</div>
		<div class="swiper-container">
		  <div class="swiper-wrapper">
		    <div class="swiper-slide"><img src='images/headswipe1.jpg' width='100%' height='100%'/></div>
		    <div class="swiper-slide"><img src='images/headswipe2.jpg' width='100%' height='100%'/></div>
		    <div class="swiper-slide"><img src='images/headswipe3.jpg' width='100%' height='100%'/></div>
		  </div>
		  <div class="swiper-pagination"></div>
		</div>
		<div class="column-title">
			
		</div>
		<div class="car-content">
		<%
		 SqlSelectCar t = new SqlSelectCar();
        List<Car> carList = null;
		try {
			carList = t.selectALLCar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Car car:carList){
			String picSrc = "upload/"+car.getName().trim()+"_carImg.jpg";
			%>
			<div class="car-content-detail hover-to-pointer hover-to-shadow"
			onclick="window.open('carDetail.jsp?id=<% out.write(String.valueOf(car.getId())); %>')">
				<img src="<% out.write(picSrc); %>"/>
				<div class="car-content-detail-text">
					<% out.write(car.getCar_brand()); %>
				</div>
				<div class="car-detail-price">
					<% out.write(Float.toString(car.getPrice())); %>万
				</div>
			</div>		
		<% } %>
			
		</div>
	</div>
	
	
		<footer>
			版权所有： XXXXXXXXXXXXXXX
		</footer>
</body>
<script src="static/js/swiper.min.js"></script>
<script>
let mySwiper = new Swiper('.swiper-container', {
	autoplay: true,//可选选项，自动滑动
	pagination: {
	    el: '.swiper-pagination',
	    clickable :true
	  }
})
function search(){
	let searchDOM = document.getElementById("search-form");
	console.log(searchDOM);
	searchDOM.submit();
}
</script>
</html>
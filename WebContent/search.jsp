<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.hb.dao.*"%>
<%@ page import="com.imut.javabean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>车辆搜索</title>
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
#search{
	margin-top: 20px;
	height: 36px;
	text-align:center;
}
#search-bar input{
	height: 30px;
	vertical-align: top;
	width: 350px;
	padding-left: 5px;
	padding-right: 5px;
	border: 2px solid #ddd;
}
#hr{
	margin-top:20px;
	height: 20px;
	background: #f8f8f8;
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
#logo:hover{
	cursor: pointer;
}
footer{
	background: #ff552e;
	height: 6vh;
	line-height: 6vh;
	font-size: 15px;
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
		<span>切换城市</span>	
		<a href="sale.jsp"><span>我要卖车</span></a>		
	</div>
	<div id="search">
		<div id="search-bar">
			<form action="search.jsp" method="get" id="search-form">
				<img src="images/headpicture.jpg" title="车之家" alt="车之家" width="216" height="36" id="logo" onclick="location.href='index.jsp'">
				<input type="text" name="search" id="search-input">
				<div style='padding:0 30px; background: #ff552e; font-size: 20px; color: #fff; cursor: pointer; user-select: none;display: inline-block;vertical-align: top;height: 36px;line-height:36px;'
				onclick="search()">
					搜车源
				</div>
			</form>
		</div>
	</div>
	
	<div id="hr">
		
	</div>
	
	<div class="car-content">
		<%
		SqlSelectCar t = new SqlSelectCar();
        List<Car> carList = null;
		try {
			carList = t.selectOrderCar((String)request.getParameter("search"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Car car:carList){
			String picSrc = "upload/"+car.getName().trim()+"_carImg.jpg";
			
			%>
			<div class="car-content-detail hover-to-pointer hover-to-shadow" onclick="window.open('carDetail.jsp?id=<% out.write(Integer.toString(car.getId()));%>')">
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
	<footer>
		版权所有：XXXXXXXXXXXXXX
	</footer>
</div>
<script>
var $_GET = (function(){
    var url = window.document.location.href.toString();
    var u = url.split("?");
    if(typeof(u[1]) == "string"){
        u = u[1].split("&");
        var get = {};
        for(var i in u){
            var j = u[i].split("=");
            get[j[0]] = j[1];
        }
        return get;
    } else {
        return {};
    }
})();
let searchInput = document.getElementById("search-input");
searchInput.value = decodeURI($_GET['search']);
function search(){
	let searchForm = document.getElementById("search-form");
	searchForm.submit();
}
</script>

</body>
</html>
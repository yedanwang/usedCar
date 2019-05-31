<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.hb.dao.*"%>
<%@ page import="com.imut.javabean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
<title>个人中心</title>
<style>
html{
	margin: 0;
	padding: 0;
	background: #fff;
}
body{
	margin: 0;
	padding: 0;
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
.body-header{
	background: #ff552e;
	height: 80px;
	line-height: 80px;
	text-align: center;
}
#logo{
	margin-top: 10px;
}
#body{
	width: 1200px;
	margin: auto;
	margin-top: 50px;
}
.menu{
	background: #fafafa;
	width: 20%;
	text-align: center;
	min-height: 500px;
}
.left{
	float: left;
}
.menu-head{
	font-size: 20px;
	font-weight: bold;
	border-bottom: 1px solid #000;
	padding: 20px 0;
}
.menu-list{
	padding: 20px 0;
	cursor: pointer;
}
.menu-list:hover{
	color: #ff552e;
}
.container{
	margin-left: 5%;
	width:70%;
}
.detail{
	margin: auto;
	background: #fff;
	overflow: hidden;
	padding: 15px 20px;
}
.detail-body{
	margin-top: 50px;
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
.big-button{
	width: 50%;
	margin: auto;
}
.chat{
	background: #21B2EE;
	color: white;
	text-align: center;
	padding: 20px 0;
	font-size: 20px;
	letter-spacing: 5px;
	cursor: pointer;
}
.title-select{
	color: #ff552e;
	font-size: 20px;
}
#mymessage{
	display: none;
}
.a-chat{
	border-radius: 4px;
    border: 1px solid #ebeef5;
    background-color: #fff;
    overflow: hidden;
    color: #303133;
    padding: 10px;
    margin: 15px 0;
    cursor: pointer;
}
.a-chat:hover{
	box-shadow: 0 2px 12px 0 rgba(0,0,0,.1);
}
.last-time{
	float: right;
}
.badge{
	background-color: #f56c6c;
    border-radius: 10px;
    color: #fff;
    display: inline-block;
    font-size: 12px;
    height: 18px;
    line-height: 18px;
    padding: 0 6px;
    text-align: center;
    border: 1px solid #fff;
}
.hidden{
	display: none;
}
.disabled{
	background: #ccc;
	cursor: not-allowed;
}
.no-car{
	text-align: center;
	color: #ff0000;
	margin-top: 50px;
	border: 5px dotted #000;
	border-radius: 20px;
	padding: 30px 0;
	letter-spacing: 3px;
}
.no-car a{
	font-size: 20px;
	font-weight: blol;
	color: #ff0000;
	text-decoration: underline;
}
</style>
</head>
<body>
<div id="page">
	<div id="header">
		<span style="position: relative; left: -1210px;" onclick="location.href='index.jsp'">首页</span>
		<% 
		if ((String)session.getAttribute("loginName") == null){
			System.out.println((String)session.getAttribute("loginName"));
			response.sendRedirect("login.jsp");
			return;
		 }else{%><span onclick="location.href='exit.jsp'">欢迎你：
		<% 
			String name = (String)session.getAttribute("loginName") ;
		        out.print(name);}
		%></span>
			<span onclick="location.href='mine.jsp'">个人中心</span>	
		<!-- <span>切换城市</span>	 -->
		<a href="sale.jsp"><span>我要卖车</span></a>		
	</div>
	<div class="body-header">
		<img src="images/headpicture.jpg"/ id="logo" height="60">
	</div>
	<div id="body">
		<div class="left menu">
			<div class="menu-head">
				个人中心
			</div>
			<div class="menu-list" onclick="select('fabu')">
				我的发布
			</div>
			<div class="menu-list" onclick="select('xiaoxi')">
				我的消息
			</div>
		</div>
		<div class="left container" id="mycar">
			<span class="title-select">我的发布</span>
			<%
		 SqlSelectCar t = new SqlSelectCar();
       Car car = new Car();
       car = null;
		try {
			car = t.selectMyCar((String)session.getAttribute("loginName"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}%>
		<%System.out.println("car"+car);if(car == null){ %>
			<div class="detail no-car ">
				您暂时还没有上传车辆，快来<a href="sale.jsp">上传车辆</a>吧！
			</div>
			<%}else{%>
			<div class="detail ">
				<div class="detail-body">
					<div style="text-align: center;">
					
				<%String picSrc = "upload/"+car.getName().trim()+"_carImg.jpg";%>
						<img src='<% out.write(picSrc); %>' width="600px">
						<span class='orange price-desc'>￥</span><span class="orange price"><% out.write(String.valueOf(car.getPrice())); %></span><span class='orange price-desc'>万</span>
					</div>
					<div>
						<div class='condition'>
							<div style="overflow: hidden;">
								<div class='condition-kuang'>
									<div><% out.write(String.valueOf(car.getMileage())); %></div>
									<div class='condition-kuang-desc'>表显里程</div>
								</div>
								<div class='condition-kuang'>
									<div><% out.write(car.getBuy_time()); %></div>
									<div class='condition-kuang-desc'>购买时间</div>
								</div>
								<div class='condition-kuang'>
									<div><%out.write(car.getCar_brand()); %></div>
									<div class='condition-kuang-desc'>品牌</div>
								</div>
								<div class='condition-kuang' style="border: none;">
									<div>	<%out.write(car.getVehicle_type()); %></div>
									<div class='condition-kuang-desc'>车型</div>
								</div>
							</div>
							<div style='border-top: 1px solid #ccc; margin-top: 20px; padding: 10px;'>
								<div>车辆描述：<% out.write(car.getCondition()); %></div>
								<div><span class="sell-title">看车地址：</span><% out.write(car.getAdress()); %></div>
							</div>
						</div>
					</div>
				</div>
				<%System.out.println(car.getStatus().trim()); %>
				<div class='chat big-button <% if(car.getStatus().trim().equals("-1")) {
					System.out.print("--------"+car.getStatus().trim().equals("-1"));
						out.print("disabled");
					}%>' onclick="cancle(this,'<%String name = (String)session.getAttribute("loginName") ; out.print(name.trim()); %>')"><i class="far fa-trash-alt"></i>下架</div>
			</div>
			<%} %>
		</div>
		<div class="left container" id="mymessage">
			<span class="title-select">我的消息</span>
			<div style="margin-top: 30px;">
			<%
		 	SqlSelectChat a = new SqlSelectChat();
        	Vector<Chat> chatList = null;
        	Vector<Chat> chatListto = null;
			try {
				chatList = a.selectAllpeopleChat((String)session.getAttribute("loginName"));
				chatListto = a.selectAlltoChat((String)session.getAttribute("loginName"));//.selectUnReadChat((String)session.getAttribute("loginName"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			for(Chat chat:chatList){
			%>
				<div class="a-chat" onclick="search('<%out.write(chat.getFromId().trim());%>',this)">
				<%out.write(chat.getFromId());  %>
					<span class="badge <% if(chat.getStatus().trim().equals("1")) {
						out.print("hidden");
					}%>">new</span>
					<span class="last-time"><%out.write(chat.getTime()); System.out.println(chat.getStatus().trim());%></span>
				</div>
				<%}
				   for(int i=0;i<chatList.size();i++)
				    	for(int j=0;j<chatListto.size();j++)
				    	{
				    		if(chatListto.elementAt(j).getToId().equals(chatList.elementAt(i).getFromId()))
				    		{
				    			chatListto.remove(j);
				    			j--;
				    		}
				    	}
				for(Chat chat:chatListto){
					  System.out.println("to"+chat.getToId().trim());
					%>
						<div class="a-chat" onclick="search('<%out.write(chat.getToId().trim());%>',this)">
						<%out.write(chat.getToId());  %>
							<span class="last-time"><%out.write(chat.getTime()); System.out.println(chat.getStatus().trim());%></span>
						</div>
						<%} 				
				%>
				
			</div>
		</div>
	</div>
</div>
<script src='static/js/jquery.min.js'></script>
<script>
let fabu = document.getElementsByClassName('container')[0];
let xiaoxi = document.getElementsByClassName('container')[1];

function search(tar, that){
	window.open('chat.jsp?to=' + tar);
	let element = that.getElementsByClassName('badge')[0]
	addClass(element, 'hidden')
}
function hasClass( elements,cName ){ 
  return !!elements.className.match( new RegExp( "(\\s|^)" + cName + "(\\s|$)") ); 
}
function addClass( elements,cName ){ 
  if( !hasClass( elements,cName ) ){ 
    elements.className += " " + cName; 
  }; 
}
function select(tar){
	fabu.style.display = 'none';
	xiaoxi.style.display = 'none';
	if (tar === 'fabu') {
		fabu.style.display = 'block';
	} else {
		xiaoxi.style.display = 'block';
	}
}
function cancle(that,tar){
	if (that.className.indexOf('disabled') == '-1') {
		$.ajax({
			type: "post",
			url: "updateCarStatusServlet",
			data: {
				"handle": 'off',
				"id": tar
			},
			success: function(data) {
				if (data == 1){
					alert('下架成功');
				} else {
					alert('下架失败');
				}
			}
		});
	} else {
		alert('无法重复下架');
	}
	
}
</script>
</body>
</html>
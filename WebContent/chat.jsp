<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%String ctxPath=request.getContextPath(); %>
 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>与XXX的聊天</title>
<style>
html{
	margin: 0;
	padding: 0;
	background: #eee;
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
#body{
	width: 1200px;
	margin: auto;
	background: #fff;
}
.chat{
	margin-top: 20px;
	border: 3px solid #aaa;
	padding: 0 0 20px 0;
	border-radius: 10px 10px 0 0;
}
.a-chat{
	padding: 5px 0;
	margin: 10px 0;
	overflow: hidden;
}
.chat-history{
	padding: 10px;
	height: 500px;
	background: #eee;
	border-radius: 10px;
	overflow: auto;
}
.chat-time{
	text-align: center;
}
.chat-body{
	min-height: 60px;
}
.left{
	float: left;
}
.chat-content{
	vertical-align: middle;
	width: 90%;
	margin: auto;
	position: relative;
	top: 20px;
}
.text-left{
	text-align: left;
}
.text-right{
	text-align: right;
}
.right{
	float: right;
	position: relative;
	top: -20px;
}
.header{
	height: 40px;
	width: 40px;
	text-align: center;
	font-size: 29px;
	background: #9eea6a;
	border-radius: 20px;
	vertical-align: middle;
	color: #fff;
}
.chat-content-text{
	padding: 10px;
	background: #9eea6a;
	border-radius: 5px;
}
.new-chat{
	margin-top: 10px;
	width: 100%;
	text-align: center;
}
.new-chat-text{
	width: 85%;
	line-height: 30px;
	height: 30px;
	font-size: 16px;
	border-radius: 10px;
	outline: none;
	padding: 5px 10px;
	border: 1px solid #dbdbdb;
	border-radius: 5px;
}
.submit-button{
	color: #fff;
    background: #67c23a;
    border-color: #67c23a;
    display: inline-block;
    line-height: 1;
    cursor: pointer;
    border: 1px solid #dcdfe6;
    -webkit-appearance: none;
    text-align: center;
    box-sizing: border-box;
    outline: 0;
    margin: 0;
    padding: 12px 20px;
    font-size: 14px;
    border-radius: 4px;
    margin-left: 12px;
}
</style>
</head>
<body>
<div id="page">
	<div id="header">
		<%if ((String)session.getAttribute("loginName") == null){%>
		<a href="login.jsp"><span>登录</span></a> /
			<a href="register.jsp"><span>注册</span></a> 
		<% }else{%><span id="welcome" onclick="location.href='exit.jsp'">欢迎你：
<% 
	String name = (String)session.getAttribute("loginName") ;
        out.print(name);}
%></span>
			<span onclick="location.href='mine.jsp'">个人中心</span>	
			<!-- <span>切换城市</span>	 -->
			<a href="sale.jsp"><span>我要卖车</span></a>		
		</div>
	<div id="body">
		<div class="chat">
			<div class="chat-history">
				
			</div>
			<div class="new-chat">
				<input class="new-chat-text" placeholder="请输入内容" id="new-chat-text" />
				<button class="submit-button" onclick="sendMessage()">发送</button>
			</div>
		</div>
	</div>
</div>
<script src="static/js/jquery.min.js"></script>
<script>
let user = $('#welcome').html()
user = user.split('：')[1].trim()

let url = window.location.href;
let toUser = decodeURI(url.split('=')[1])

document.onkeydown=function(event){
     var e = event || window.event || arguments.callee.caller.arguments[0];      
     if(e && e.keyCode==13){ // enter 键
        e.preventDefault();
     	sendMessage();
	}
}

window.onload = function () {
	selectChat()
	setInterval("selectChat()", 10000)
	let to = decodeURI(location.href.split("=")[1])
	document.title = `与`+to+`沟通中`
	setTimeout(toBottom, 100)
}

function toBottom(){
	let history = document.getElementsByClassName('chat-history')[0];
	history.scrollTop = history.scrollHeight
}

function sendMessage() {
	let val = $("#new-chat-text").val().trim()
	if (val === '') {
		alert('请勿发送空消息');
		return
	}
	let time = new Date()
	let year = time.getFullYear()
	let month = time.getMonth() + 1
	let date = time.getDate()
	let hour = time.getHours()
	let min = time.getMinutes()
	let sec = time.getSeconds()
	if (sec < 10) {
		sec = '0' + sec
	}
	if (min < 10) {
		min = '0' + min
	}
	if (hour < 10) {
		hour = '0' + hour
	}
	time = year + '-' + month + '-' + date + ' ' + hour + ':' + min + ':' + sec
	let me = user
	let newMessageDom = $('<div class="a-chat"><div class="chat-time"><span style="background: rgb(218, 218, 218); padding: 2px 10px; border-radius: 5px; color: #fff;">'+time+'</span></div><div class="chat-body"><div class="left header" style="display: none;">'+me+'</div><div class="chat-content text-right"><span class="chat-content-text">'+val+'</span></div><div class="right header">'+me+'</div></div></div>')
	$(".chat-history").append(newMessageDom)
	$("#new-chat-text").val('')
	toBottom()
	$.ajax({
		url:'InsertChatServlet',
		type: 'POST',
		data:{to: toUser, content: val},
		success:function(res) {
			if (res != 1){
				alert('插入失败')
			}
		},
		error:function(err) {
			console.log('网络错误')
		}
	})
}

function selectChat() {
	$.ajax({
		url: 'selectChatServlet',
		method: 'post',
		data: {id: toUser},
		success: function(res) {
			selectToDom(res.data)
		},
		error: function(err) {
			console.log(err)
		}
	})
}

function selectToDom (data) {
	let chatHistory = $(".chat-history").first()
	chatHistory.html('')
	let newMessageDom = ''
	let time = ''
	let me = ''
	let val = ''
	for (let i of data) {
		val = i.content
		time = i.time
		if (i.from === user) {
			me = user[0]
			newMessageDom = $('<div class="a-chat"><div class="chat-time"><span style="background: rgb(218, 218, 218); padding: 2px 10px; border-radius: 5px; color: #fff;">'+time+'</span></div><div class="chat-body"><div class="left header" style="display: none;">'+me+'</div><div class="chat-content text-right"><span class="chat-content-text">'+val+'</span></div><div class="right header">'+me+'</div></div></div>')
		} else {
			me = i.from[0]
			newMessageDom = $('<div class="a-chat"><div class="chat-time"><span style="background: rgb(218, 218, 218); padding: 2px 10px; border-radius: 5px; color: #fff;">'+time+'</span></div><div class="chat-body"><div class="left header">'+me+'</div><div class="chat-content text-left"><span class="chat-content-text">'+val+'</span></div><div class="right header" style="display: none;">'+me+'</div></div></div>')
		}
		chatHistory.append(newMessageDom)
	}
}
</script>
</body>
</html>

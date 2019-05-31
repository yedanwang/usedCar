<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>ssc车之家 管理员登录</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
    <link type="text/css" rel="stylesheet" href="static/css/login.css">
    <script type="text/javascript" src="static/js/jquery.min.js"></script>
    <style>
        form input{
            margin-top: 20px;
        }
        .hover-to-pointer:hover{
        	cursor:pointer;
        }
    </style>
</head>
<body class="admin_login_bj" >
<div class="zhuce_body">
	<div class="logo"><a href="#"><img src="images/headpicture.jpg" width="252" height="42" border="0"></a></div>
    <div class="zhuce_kong login_kuang">
    	<div class="zc">
        	<div class="bj_bai" style="width: 280px; height: 300px; margin-left: 90px;">
            <h3>登录</h3>
       	  	  <form action="loginAdminServlet" method="post">
                <input name="loginName" type="text" class="kuang_txt phone" placeholder="用户名">
                <input name="password" type="password" class="kuang_txt password" placeholder="密码">
                <input name="登录" type="submit" class="btn_zhuce" value="登录">
                </form>	
            </div>
        </div>
    </div>
</div>
    
</body>
</html>
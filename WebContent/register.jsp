<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>ssc车之家  用户注册</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
    <link type="text/css" rel="stylesheet" href="static/css/login.css">
    <script type="text/javascript" src="static/js/jquery.min.js"></script>
    <style>
        form input{
            margin-top: 3px;
        }
        .hover-to-pointer:hover{
       		cursor:pointer;
        }
       
    </style>
</head>
<body class="login_bj" >
<div class="zhuce_body">
	<div class="logo"><a href="#"><img src="images/headpicture.jpg" width="252" height="42" border="0"></a></div>
    <div class="zhuce_kong">
    	<div class="zc">
        	<div class="bj_bai">
            <h3>欢迎注册</h3>
       	  	  <form action="RegisterServlet" method="post">
                <input name="loginName" type="text" class="kuang_txt uname" placeholder="用户名" required autocomplete="off"><br>
                <input name="password" type="password" class="kuang_txt possword" placeholder="密码" required>
                <input name="phone" type="text" class="kuang_txt phone" placeholder="手机号码" required pattern="1[34578]\d{9}" autocomplete="off">
                <input name="address" type="text" class="kuang_txt address" placeholder="地址" required autocomplete="off">
                <input name="注册" type="submit" class="btn_zhuce" value="注册">
              </form>
              <span style="margin: 50px; 0 0 50px;">已有账号？现在<span style="color: #37b5f9;" class="hover-to-pointer" onclick="location.href='login.jsp'">登录</span></span>
            </div>
        </div>
        <P>欢迎注册 ssc车之家 二手车交易平台</P>
    </div>
</div>
    

</body>
</html>

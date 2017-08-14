<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>授权网站</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<style>
		body, h1, h2, h3, h4, div, span, p, ul, li, dl, dt, dd, ol, li, a, input, textarea, img { margin: 0; padding: 0; border: 0; list-style: none; outline: 0 }
		body { width: 100%; height: 100%;  font-family: "微软雅黑";  background: url(images/bg.png) 0 0 repeat; margin: auto; overflow:hidden; }
		a { color: #000; text-decoration: none;font-size: 24px; margin-left: 150px;}
		a:hover {  text-decoration: none }
		#bgbox{ width: 700px;  margin: 20px auto; background: url(images/bg12.png) 0 0 no-repeat;  overflow: hidden;}
		.name{ width: 100%; height: 50px; font-size: 30px; color: #ffffff;  margin-top: 160px; margin-left: 100px; }
		input{  width: 280px; height: 28px; background: #ffffff; margin-left: 30px; font-size: 24px; text-align: center; line-height: 28px;}
		
		.possword{  width: 100%; height: 50px; font-size: 30px; color: #ffffff;  margin-top: 50px; margin-left: 100px;  }
		.button{ width: 146px; height: 38px; background: #ffffff;font-size: 24px; text-align: center; line-height: 38px; color: #000; margin-left: 150px; margin-top:70px; /* display: block; */ }
	</style>
  </head>
  
  <body scroll="no">
  <div id="bgbox">
    <form action="usersave" method="post">
			<div class="name">用户名: <input type="text" class="me" value="" id="userName" name="userName"></div>
			<div class="possword">密&nbsp;&nbsp;&nbsp;码: <input type="password" class="word" value="" id="password" name="password"></div>
			<div class="possword">密&nbsp;&nbsp;&nbsp;码: <input type="password" class="word" value="" id="password2" name="password2"></div>
			<div class="possword">电&nbsp;&nbsp;&nbsp;话: <input type="text" class="word" value=""  id="mobile" name="mobile"></div>
			<div class="possword">email&nbsp;: <input type="text" class="word" value="" id="email" name="email"></div>
			<!-- <a href="platform.html" class="button">登陆</a> -->
			 <a href="login.jsp">返回</a><input type="submit" value="提交" class="button">
	</form>
	</div>
  </body>
</html>

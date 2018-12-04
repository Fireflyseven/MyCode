<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<title>欢迎使用WEB实验管理系统</title>
<c:import url="/WEB-INF/jsp/source.jsp"></c:import>
</head>
<body>
	<!-- head -->
	<div class="container">
		<div class="navbar">
			<div class="navbar-inner">
				<div class="container">
					<a class="btn btn-navbar" data-toggle="collapse"
						data-target=".nav-collapse"> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
					</a> <a class="brand bold" href="#">WEB实验管理系统</a>
					<div class="nav-collapse">
						<ul class="nav">
							<li><a href="index.html">首页</a></li>
							<li><a href="help.htm">帮助</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- content -->
	<div class="container">
		<div id="login-page">
			<h3>登录</h3>
			<form id="login-form" class="well" action="<c:url value="/login"/>"
				method="post">
				<input type="text" name="username" class="span2" placeholder="用户名" /><br />
				<input type="password" name="password" class="span2"
					placeholder="密码" /><br /> <select name="type">
					<option value="1">老师</option>
					<option value="2">学生</option>
					<option value="3">管理员</option>
				</select> <label class="checkbox"> <input type="checkbox" /> 记住密码
				</label> <input type="submit" class="btn btn-primary" value="登录系统" /> <a
					href="#">忘记密码</a>
			</form>
		</div>
		<img id="pic" src="sources/img/home.jpg" width="750px" />
	</div>
</body>
</html>
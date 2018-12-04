<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
<style type="text/css">
.login{
	position:relative;
	left:40%;
	margin-top: 10%	
}
.form-lable{
	color:blue;
}
.form-input{
	font-size:20px;
	border:none;
	border-bottom: 2px solid blue;
	margin:10px;
}
.form-button{
	font-size:20px;
	text-align:center;
	border:2px solid blue;
	background:transparent;
	color:blue;
	width:225px;
	margin:20px;
}
.form-button:hover{
	background:blue;
	color:white;
}
.error{
	color:red;
}
</style>
</head>
<body>
<div class="login">
	<form action="">
		<div class="form-lable">用户名</div>
		<input type="text" name="username" class="form-input"><br>
		<div class="form-lable">密码</div>
		<input type="text" name="password" class="form-input"><br>
		<p class="error">用户名或密码不正确</p>
		<input type="submit" value="登录" class="form-button">
	</form>
</div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${session.username}</title>
<style type="text/css">
.nav-list {
	list-style: none;
	width: 1200px;
}
.nav-item {
	float: left;
	margin: 10px;
	font-size: 30px;
	color: blue;
}
.content {
	position: absolute;
	top: 100px;
}
.post {
	margin: 10px auto 0 100px;
	width: 1100px;
	position: relative;
}
.post>a {
	display: inline-block;
	width: 510px;
	height: 330px;
	overflow: hidden;
	position: relative;
	z-index: 3;
}
.else {
	position: absolute;
	background: #fff;
	text-align: left;
	top: 15px;
	height: 298px;
	width: 600px;
	border: 2px solid blue;
}
.post:nth-child(odd) {
	text-align: left;
}
.post:nth-child(even) {
	text-align: right;
}
.post:nth-child(odd) .else {
	left: 500px;
}
.post:nth-child(even) .else {
	right: 500px;
}
.else p:first-child {
	color: #999;
	margin: 80px 0 0 80px;
}
.else h3 {
	font-size: 30px;
	margin: 10px 100px 0 80px;
}
.else p {
	color: #555;
	margin: 10px 100px 0 80px;
	overflow: hidden;
}
.nav-item:hover,.active,.title:hover{
	background:blue;
	color:white;
}
</style>
</head>
<body>
	<div class="nav">
		<ul class="nav-list">
			<li class="nav-item active"><a>主页</a></li>
			<li class="nav-item"><a>标签</a></li>
			<li class="nav-item"><a>存档</a></li>
			<li class="nav-item"><a>关于</a></li>
		</ul>
	</div>
	<div class="content">
		<div class="post">
			<a href=""> <img alt="" src="img/2.jpg" width="680px"
				height="440px">
			</a>
			<div class="else">
				<p >2018-01-02 12:22</p>
				<h3 class="title">Title</h3>
				<p>Testteestssgfsdhfisahfsjfestteestssgfsdhfisahfsjfbgiadnsabsfhbestteestssgfsdhfisahfsjfbgiadnsabsfhbestteestssgfsdhfisahfsjfbgiadnsabsfhbbgiadnsabsfhbv</p>
			</div>
		</div>
		<div class="post">
			<a href=""> <img alt="" src="img/1.jpg" width="680px"
				height="440px">
			</a>
			<div class="else">
				<p >2018-01-02 12:22</p>
				<h3 class="title">Title</h3>
				<p>Testteestssgfsdhfisahfsjfbgiadnsabsfhbv</p>
			</div>
		</div>
	</div>
</body>
</html>

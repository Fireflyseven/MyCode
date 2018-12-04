<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<body>
	<div class="container">
		<div class="navbar">
			<div class="navbar-inner">
				<div class="container">
					<a class="btn btn-navbar" data-toggle="collapse"
						data-target=".nav-collapse"> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
					</a> <a class="brand" href="#">WEB实验管理系统</a>
					<div class="nav-collapse">
						<ul class="nav">
							<li><a href="#">首页</a></li>
							<li><a href="#">帮助</a></li>
						</ul>
						<%
							String usr=(String)session.getAttribute("usr");
						%>
						<ul class="nav pull-right">
							<li><a href="#"><span class="badge">1</span></a></li>
							<li><a href="#">@<%=usr %></a></li>
							<li><a href="/WebExManager/">注销</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
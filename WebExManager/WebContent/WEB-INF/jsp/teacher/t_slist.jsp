<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${ex.experimenttitle}</title>
<c:import url="/WEB-INF/jsp/source.jsp"></c:import>
</head>
<body>
	<!-- head -->
	<c:import url="/WEB-INF/jsp/nav.jsp"></c:import>
	<!-- content -->
	<div class="container">
		<div class="row">
			<div class="span3">
				<c:import url="t_menu.jsp"></c:import>
			</div>
			<div class="span9">
				<h3>${ex.experimenttitle}</h3>
				<br>
				<hr>
				<div class="menu">
					<form class="form-search">
						<input type="text" name="search" placeholder="请输入学号或班级号"
							class="input-medium search-query" /> <input type="submit"
							class="btn btn-primary" value="查询">
					</form>
				</div>
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>学号</th>
							<th>姓名</th>
							<th>实验名</th>
							<th>分数</th>
							<th>操作</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${gs}" var="s">
							<tr>
								<td>${s.username}</td>
								<td>${s.name}</td>
								<td>${ex.experimenttitle}</td>
								<td>${s.grade }</td>
								<td><a
									href="/WebExManager/t_check/${s.username}/${s.exid}001"
									class="btn btn-success"><i class="icon-ok icon-white"></i>批改</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<a href=""><button class="btn btn-warning"><i class="icon-print icon-white"></i>打印成绩单</button></a>
			</div>
		</div>
	</div>
</body>
</html>

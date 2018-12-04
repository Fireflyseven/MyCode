<%@page import="model.Experiment"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>欢迎使用WEB实验管理系统</title>
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
				<h3>实验</h3>
				<span class="menu"> <a href="<c:url value="/add_ex_form" />"
					class="btn btn-success"><i class="icon-plus-sign icon-white"></i>安排新实验</a>
				</span>
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>实验名称</th>
							<th>完成期限</th>
							<th>对象</th>
							<th>命题老师</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${exs}" var="ex">
							<tr>
								<td>${ex.experimenttitle}</td>
								<td>${ex.deadline}</td>
								<td>${ex.stutype}</td>
								<td>${ex.teachername}</td>
								<td><span class="badge"> ${ex.state}</span></td>
								<td><a href="t_qlist/${ex.experimentid}"
									class="btn btn-primary"><i class="icon-edit icon-white"></i>编辑</a> <a
									href="t_slist/${ex.experimentid}" class="btn btn-warning"><i class="icon-check icon-white"></i>批改</a>
									<a href="del_ex/${ex.experimentid} " class="btn btn-danger"><i class="icon-remove icon-white"></i>取消</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>

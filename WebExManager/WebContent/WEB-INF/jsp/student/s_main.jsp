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
				<c:import url="s_menu.jsp"></c:import>
			</div>
			<div class="span9">
				<h3>实验</h3>
				<span class="menu"> <a href="#" class="btn btn-warning"><i class="icon-download-alt icon-white"></i>下载实验资料</a>
				</span>
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>实验名称</th>
							<th>完成期限</th>
							<th>命题老师</th>
							<th>状态</th>
							<th>分数</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${exs}" var="ex">
							<tr>
								<td>${ex.experimenttitle}</td>
								<td>${ex.deadline}</td>
								<td>${ex.teachername}</td>
								<td><span class="badge"> ${ex.state}</span></td>
								<c:forEach items="${gs}" var="g">
									<c:if test="${ex.experimentid ==g.exid}">
										<td>${g.grade}</td>
									</c:if>
								</c:forEach>
								<td><a href="s_qlist0/${ex.experimentid} "
									class="btn btn-success"><i class=" icon-edit icon-white"></i>做实验</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>

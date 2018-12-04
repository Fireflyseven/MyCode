<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>文件</title>
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
				<h3>文件</h3>

				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>文件名</th>
							<th>文件类型</th>
							<th>上传日期</th>
							<th>操作</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${files}" var="f">
							<tr>
								<td>${f.filename}</td>
								<td>${f.remark}</td>
								<td>${f.date }</td>

								<td><a
									href="download?filename=${f.filename}&remark=${f.remark} "
									class="btn btn-warning"><i class="icon-download-alt icon-white"></i>下载</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			</div>
			</div>
			<script src="sources/js/jquery.min.js"></script>
			<script src="sources/js/bootstrap.min.js"></script>
			<script src="sources/js/site.js"></script>
</body>
</html>

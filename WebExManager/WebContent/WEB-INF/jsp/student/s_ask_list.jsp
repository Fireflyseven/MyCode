<%@page import="model.Ask"%>
<%@page import="model.Reply"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>疑问</title>
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
				<h3>答疑</h3>
				<span class="menu"> <a href="/WebExManager/add_ask_form"
					class="btn btn-success"><i class="icon-question-sign icon-white"></i>提问</a>
				</span>
				<hr>
				<ul class="thumbnails">
					<c:forEach items="${a}" var="ask">

						<li class="span4">
							<div class="thumbnail">
								<h3>${ask.asktitle}</h3>
								<small>@ ${ask.username}</small>
								<p>${ask.asktext}</p>
								<p>
									<a href="<c:url value="/s_reply/${ask.askid}" />"
										class="btn btn-primary"><i class="icon-comment icon-white"></i>回复</a> <a
										href="<c:url value="/del_ask/${ask.askid}"/>"
										class="btn btn-danger"><i class=" icon-remove icon-white"></i>删除</a>
								</p>
							</div>
						</li>

					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>

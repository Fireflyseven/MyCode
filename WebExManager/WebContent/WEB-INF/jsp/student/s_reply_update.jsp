<%@page import="model.Reply"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>修改回复</title>
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

				<form:form commandName="r" action="/WebExManager/s_update_reply"
					method="get">
					<form:input type="hidden" value="${reply.askid}" path="asktid" />
					<br>
					<label>问题内容：${ask.asktext}</label>
					<form:input type="text" path="replyid" disabled />
					<br>
					<label>内容</label>
					<form:textarea id="replytext" path="replytext"
						value="${reply.replytext }" />
					<span class="menu"> <input id="reset" type="reset"
						class="btn btn-warning" /> <input id="submit" type="submit"
						value="确定" class="btn btn-success" />
					</span>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>
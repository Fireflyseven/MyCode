<%@page import="model.Reply"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>回复</title>
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
				<h3>新增回复</h3>
				<form:form commandName="r" action="/WebExManager/submit_reply"
					method="get">
					<form:input type="hidden" value="${a.askid}" path="askid" />
					<h3>${a.asktext}</h3>
					<label>回复编号：${r.askid}_ _ </label>(填2位数字)
					<form:input type="text" path="replyid" value="${r.replyid }" />
					<label>回复内容</label>
					<form:textarea id="replytext" style="width:700px;height:200px;"
						path="replytext" value="${r.replytext}" />
					<span class="menu"> <input id="reset" type="reset"
						class="btn btn-warning" /> <input id="submit" type="submit"
						value="回复" class="btn btn-success" />
					</span>
				</form:form>
			</div>
		</div>
	</div>
	<script>
		KindEditor.ready(function(K) {
			window.editor = K.create('#replytext');
		});
	</script>
</body>
</html>
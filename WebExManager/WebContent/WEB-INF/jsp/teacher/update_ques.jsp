<%@page import="model.Experiment"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>编辑题目</title>
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
				<h3>编辑</h3>
				<form:form commandName="qu" action="update_que" method="get">
					<form:input type="hidden" value="${ex.experimentid}"
						path="experimentid" />
					<br>
					<label>实验名称：${ex.experimenttitle}</label>
					<label>题号：</label>
					<input type="text" value="${qu.questionid}" disabled />
					<br>
					<form:input type="hidden" path="questionid"
						value="${qu.questionid}" />
					<br>
					<label>题目标题：</label>
					<form:input id="questiontitle" path="questiontitle"
						value="${qu.questiontitle}" />
					<br>
					<label>题干</label>
					<form:textarea id="questiontext" path="questiontext"
						value="${qu.questiontext }" />
					<label>答案</label>
					<form:textarea id="answer" name="answer" path="answer"
						value="${qu.answer}" />
					<label>分值</label>
					<form:input type="text" id="score" path="score" value="${qu.score}" />
					<span class="menu"> <input id="reset" type="reset"
						class="btn btn-warning" /> <input id="submit" type="submit"
						value="提交" class="btn btn-success" />
					</span>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>
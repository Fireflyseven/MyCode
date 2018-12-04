<%@page import="model.Experiment"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>添加题目</title>
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
				<h3>添加题目</h3>
				<form:form commandName="q" action="add_que" method="get">
					<form:input type="hidden" value="${ex.experimentid}"
						path="experimentid" />
					<label>实验名称：</label>
					<input type="text" id="experimenttitle"
						value="${ex.experimenttitle}" />
					<br />
					<label>题号：${ex.experimentid}_ _ _</label>
					<form:input type="text" path="questionid" />(填3位数字)
					<label>题目标题</label>
					<form:input id="questiontitle" path="questiontitle" />
					<label>题干</label>
					<form:textarea id="questiontext" style="width:700px;height:200px;"
						path="questiontext" />
					<label>答案</label>
					<form:textarea id="answer" style="width:700px;height:300px;"
						name="answer" path="answer" />
					<label>分值</label>
					<form:input type="text" id="score" path="score" />
					<span class="menu"> <input id="reset" type="reset"
						class="btn btn-warning" /> <input id="submit" type="submit"
						value="提交" class="btn btn-success" />
					</span>
				</form:form>
			</div>
		</div>
	</div>
	<script>
		KindEditor.ready(function(K) {
			window.editor = K.create('#questiontext');
			window.editor = K.create('#answer');
		});
	</script>
</body>
</html>
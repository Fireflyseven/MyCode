<%@page import="model.Ask"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>添加问题</title>
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
				<h3>提问</h3>
				<form:form commandName="ask" action="add_ask" method="get">
					<label for="asktitle">问题标题</label>
					<form:input id="asktitle" path="asktitle" />
					<label for="asktext">问题内容</label>
					<form:textarea id="asktext" style="width:700px;height:200px;"
						path="asktext" /><br>
					<input id="reset" type="reset"
						class="btn btn-warning" /> <input id="submit" type="submit"
						value="提问" class="btn btn-success" />
				</form:form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		laydate.render({
			elem : '#deadline',
			type : 'datetime'

		});
	</script>
</body>
</html>
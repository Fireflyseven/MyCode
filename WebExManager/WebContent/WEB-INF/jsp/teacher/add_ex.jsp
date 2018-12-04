<%@page import="model.Experiment"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>安排新实验</title>
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
				<h3>安排新实验</h3>
				<form:form commandName="e" action="add_ex" method="get">
					<label for="experimentid">实验编号 (例：201801)</label>
					<form:input id="experimentid" path="experimentid" />
					<label for="stutype">实验对象</label>
					<form:select path="stutype" id="stutype">
						<form:option value="1">大一学生</form:option>
						<form:option value="2">大二学生</form:option>
						<form:option value="3">大三学生</form:option>
						<form:option value="4">大四学生</form:option>
					</form:select>
					<label for="experimenttitle">实验标题</label>
					<form:input id="experimenttitle" path="experimenttitle" />
					<label for="deadline">截止时间</label>
					<form:input id="deadline" name="deadline" path="deadline" />
					<label for="teachername">老师姓名</label>
					<form:input id="teachername" path="teachername" />
					<span class="menu"> <input id="reset" type="reset"
						class="btn btn-warning" /> <input id="submit" type="submit"
						value="提交" class="btn btn-success" />
					</span>
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

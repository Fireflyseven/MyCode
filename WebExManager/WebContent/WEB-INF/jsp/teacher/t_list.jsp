<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${ex.experimenttitle}</title>
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
				<h3>${ex.experimenttitle}</h3>
				<form:form commandName="e" action="update_ex" method="get">
					实验编号
					<input type="text" value="${ex.experimentid}" disabled />
					<br>
					<form:input id="experimentid" type="hidden" path="experimentid"
						value="${ex.experimentid}" />
					<br>
					实验对象
					<form:select path="stutype" id="stutype" value="${ex.stutype }">
						<form:option value="1">大一学生</form:option>
						<form:option value="2">大二学生</form:option>
						<form:option value="3">大三学生</form:option>
						<form:option value="4">大四学生</form:option>
					</form:select>
					<br>
					实验标题
					<form:input id="experimenttitle" path="experimenttitle"
						value="${ex.experimenttitle}" />
					<br>
					截止时间
					<form:input id="deadline" name="deadline" path="deadline"
						value="${ex.deadline}" />
					<br>
					老师姓名
					<form:input id="teachername" path="teachername"
						value="${ex.teachername}" />
					<br>
					<form:input type="hidden" path="state" value="${ex.state}" />
					<span> <input id="reset" type="reset"
						class="btn btn-warning" /> <input id="submit" type="submit"
						value="提交修改" class="btn btn-success" />
					</span>
				</form:form>

				<br>
				<hr>
				<h3>题目列表</h3>
				<span class="menu"> <a
					href="<c:url value="/add_ques_form/${ex.experimentid}"/>"><button
							class="btn btn-primary"><i class="icon-plus-sign icon-white"></i>添加题目</button></a>
				</span>
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>题号</th>
							<th>标题</th>
							<th>题干</th>
							<th>分值</th>
							<th>操作</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${qs}" var="q">
							<tr>
								<td>${q.questionid}</td>
								<td>${q.questiontitle}</td>
								<td>${q.questiontext}</td>
								<td>${q.score}</td>
								<td><a href="t_qedit/${q.questionid} "
									class="btn btn-warning"><i class="icon-edit icon-white"></i>编辑</a> <a
									href="t_qdelete/${q.questionid}" class="btn btn-danger"><i class="icon-remove icon-white"></i>删除</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
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

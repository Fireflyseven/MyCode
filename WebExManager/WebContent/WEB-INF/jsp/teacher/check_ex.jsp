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
				<div class="pagination">
					<ul>
						<li><a
							href="/WebExManager/t_qpre/${s.username }/${qu.questionid}">Prev</a></li>
						<c:forEach items="${qs}" var="q">
							<li><a
								href="/WebExManager/t_check/${s.username }/${q.questionid}">${q.questionid }</a></li>
						</c:forEach>
						<li><a
							href="/WebExManager/t_qnext/${s.username }/${qu.questionid}">Next</a></li>
					</ul>
				</div>
				<hr>
				<h4></h4>
				<pre>学号:${s.username}		姓名:${s.name }
实验:${ex.experimenttitle}		题号:${qu.questionid}		分值:${qu.score}</pre>
				<hr>
				<h5>${qu.questiontext}</h5>
				<pre style="width: 850px; height: 250px;">${an.answertext }</pre>
				<div class="menu">
					<form:form commandName="an" action="/WebExManager/save_grade"
						method="get">
						<form:input type="hidden" value="${an.answerid}" path="answerid" />
						<form:input path="score" value="${an.score}" class="input-medium" />
						<input type="submit" class="btn btn-success" value="提交分数" />
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

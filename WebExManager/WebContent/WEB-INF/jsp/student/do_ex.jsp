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
				<c:import url="s_menu.jsp"></c:import>
			</div>
			<div class="span9">
				<div class="pagination">
					<ul>
						<li><a href="/WebExManager/s_qpre/${qu.questionid}">Prev</a></li>
						<c:forEach items="${qs}" var="q">
							<li><a href="/WebExManager/s_qlist/${q.questionid}">${q.questionid }</a></li>
						</c:forEach>
						<li><a href="/WebExManager/s_qnext/${qu.questionid}">Next</a></li>
					</ul>
				</div>
				<hr>
				<h4>${ex.experimenttitle}</h4>
				<p>题号:${qu.questionid}</p>
				<p>分值:${qu.score}</p>
				<hr>
				<h5>${qu.questiontext}</h5>
				<form:form commandName="an" action="/WebExManager/save_answer"
					method="get">
					<form:input type="hidden" value="${qu.questionid}"
						path="questionid" />
					<form:textarea id="answertext" style="width:700px;height:300px;"
						name="answertext" path="answertext" value="${an.answertext }" />
					<br>
					<input type="submit" class="btn btn-success" />
					<input type="reset" class="btn btn-warning" />
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
	<script>
		KindEditor.ready(function(K) {
			window.editor = K.create('#answertext');
		});
	</script>
</body>
</html>

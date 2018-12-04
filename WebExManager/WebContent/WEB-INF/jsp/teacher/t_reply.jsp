<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${ask.asktitle}</title>
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
				<div class="media">
					<a href="<c:url value="/t_add_reply_form/${a.askid }" />"
						class="pull-right btn btn-success"><i class="icon-comment icon-white"></i>回复</a>
					<div class="media-body">
						<h2 class="media-heading">${a.asktitle }</h2>
						<h4>${a.asktext }</h4>
						<hr>
						<c:forEach items="${r}" var="reply">
							<div class="media well">
								<a href="/WebExManager/t_del_reply/${reply.replyid}"
									class="pull-right btn btn-danger"><i
									class="icon-remove icon-white"></i></a> <a href=""
									class="pull-right btn btn-warning"><i
									class=" icon-chevron-down icon-white"></i></a> <a href=""
									class="pull-right btn  btn-success"><i
									class=" icon-chevron-up icon-white"></i></a>
								<div class="media-body">
									<h4 class="media-heading">@${reply.username }</h4>
									<p>${reply.replytext}</p>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

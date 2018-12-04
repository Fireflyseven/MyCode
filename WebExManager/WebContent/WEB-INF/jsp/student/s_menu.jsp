<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="well" style="padding: 8px 0;">
	<ul class="nav nav-list">
		<li class="nav-header">操作</li>
		<li><a href="<c:url value="/s_list"/>"><i class="icon-check"></i>实验</a></li>
		<li><a href="<c:url value="/s_file"/>"><i class="icon-file"></i>文件</a></li>
		<li><a href="<c:url value="/s_a_list"/>"><i
				class="icon-envelope"></i>问答</a></li>
		<li class="nav-header">个人中心</li>
		<li><a href="#"><i class="icon-user"></i>个人资料</a></li>
		<li><a href="#"><i class="icon-cog"></i>设置</a></li>
		<li class="divider"></li>
		<li><a href="#"><i class="icon-info-sign"></i>帮助</a></li>
	</ul>
</div>

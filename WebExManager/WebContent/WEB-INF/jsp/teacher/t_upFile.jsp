<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
<c:import url="/WEB-INF/jsp/source.jsp"></c:import>

</head>
<body>
	<c:import url="/WEB-INF/jsp/nav.jsp"></c:import>
	<div class="container">
		<div class="row">
			<div class="span3">
				<c:import url="t_menu.jsp"></c:import>
			</div>
			<div class="span9">
				<h3>文件上传</h3>

				<form action="register" enctype="multipart/form-data" method="post">
					<table>
						<tr>
							<td>文件名:</td>
							<td><input type="text" name="fileName"></td>
						</tr>
						<tr>
							<td>文件类型:</td>
							<td><select name="remark">

									<option value=".jpg">jpg</option>
									<option value=".doc">doc</option>
									<option value=".docx">docx</option>
									<option value=".ppt">ppt</option>
									<option value=".zip">zip</option>
									<option value=".rar">rar</option>
									<option value=".java">java</option>

							</select></td>
						</tr>
						<tr>
							<td>请选择文件:</td>
							<td><input type="file" name="file"></td>
						</tr>
						<tr>
							<td></td>
						</tr>
						<tr>
							<td><input type="submit" class=" btn btn-primary" value="上传"/></td>
							<td><input type="reset" class="btn btn-default" value="重置"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>

</body>
</html>
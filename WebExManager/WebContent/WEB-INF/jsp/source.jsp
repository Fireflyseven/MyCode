<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link href="<%=path%>/sources/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=path%>/sources/css/bootstrap-responsive.min.css"
	rel="stylesheet">
<link href="<%=path%>/sources/css/site.css" rel="stylesheet">
<script src="<%=path%>/sources/js/jquery.min.js"></script>
<script src="<%=path%>/sources/js/bootstrap.min.js"></script>
<script src="<%=path%>/sources/js/site.js"></script>
<script src="<%=path%>/sources/laydate/laydate.js"></script>
<script charset="utf-8" src="<%=path%>/sources/editor/kindeditor-all.js"></script>
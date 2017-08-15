<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${resultMap.pageMsg == 'success' }">
			<span class="c-blue">订单提交成功</span>
			<a data-href="${resultMap.referURL}" data-title="订单列表" href="javascript:;" onclick="Hui_admin_tab(this)" style="text-decoration:none;">订单列表</a>
		</c:when>
		<c:otherwise>
			<span class="c-red">${resultMap.pageMsg }</span>
		</c:otherwise>
	</c:choose>
<script type="text/javascript" src="/view/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="/view/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="/view/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="/view/static/h-ui.admin/js/H-ui.admin.js"></script>
<script type="text/javascript"></script>
</body>
</html>